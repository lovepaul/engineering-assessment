package org.yjc.foodcar.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yjc.foodcar.common.PageRequest;
import org.yjc.foodcar.common.Response;
import org.yjc.foodcar.mapper.FoodTruckMapper;
import org.yjc.foodcar.model.FoodTruck;


import java.util.List;

@Service
public class FoodTruckService {

    @Autowired
    private FoodTruckMapper foodTruckMapper;

    // 1. 通过 ID 获取食品卡车详情
    public FoodTruck getFoodTruckById(Long id) {
        return foodTruckMapper.selectOne(new QueryWrapper<FoodTruck>().eq("location_id", id));
    }

    // 2. 获取所有的食品类型，用于筛选
    public List<String> getAllFoodItems() {
        QueryWrapper<FoodTruck> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT food_items");
        return foodTruckMapper.selectObjs(queryWrapper);
    }

    // 3. 根据食品类型查询食品卡车 (分页)
    public Response<IPage<FoodTruck>> searchFoodTrucksByFoodItem(String foodItem, int pageNum, int pageSize) {
        QueryWrapper<FoodTruck> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("food_items", foodItem);
        Page<FoodTruck> page = new Page<>(pageNum, pageSize);
        IPage<FoodTruck> resultPage = foodTruckMapper.selectPage(page, queryWrapper);
        return Response.success(resultPage);
    }

    // 4. 根据申请人(applicant)查询食品卡车 (分页)
    public Response<IPage<FoodTruck>> searchFoodTrucksByApplicant(String applicant, int pageNum, int pageSize) {
        QueryWrapper<FoodTruck> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("applicant", applicant);
        Page<FoodTruck> page = new Page<>(pageNum, pageSize);
        IPage<FoodTruck> resultPage = foodTruckMapper.selectPage(page, queryWrapper);
        return Response.success(resultPage);
    }

    // 5. 分页获取食品卡车列表 (已经实现)
    public Response<IPage<FoodTruck>> getFoodTrucksByPage(PageRequest pageRequest) {
        QueryWrapper<FoodTruck> queryWrapper = new QueryWrapper<>();
        if (pageRequest.getApplicant() != null && !pageRequest.getApplicant().isEmpty()) {
            queryWrapper.like("applicant", pageRequest.getApplicant());
        }
        if (pageRequest.getFoodItem() != null && !pageRequest.getFoodItem().isEmpty()) {
            queryWrapper.like("food_items", pageRequest.getFoodItem());
        }
        Page<FoodTruck> page = new Page<>(pageRequest.getPageNum(), pageRequest.getPageSize());
        IPage<FoodTruck> resultPage = foodTruckMapper.selectPage(page, queryWrapper);
        return Response.success(resultPage);
    }
}
