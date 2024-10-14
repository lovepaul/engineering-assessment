package org.yjc.foodcar.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yjc.foodcar.common.PageRequest;
import org.yjc.foodcar.common.Response;
import org.yjc.foodcar.model.FoodTruck;
import org.yjc.foodcar.service.FoodTruckService;

import java.util.List;

@RestController
@RequestMapping("/api/food-trucks")
@CrossOrigin(origins = "http://localhost:3000")  // 允许来自 localhost:3000 的跨域请求
public class FoodTruckController {

    @Autowired
    private FoodTruckService foodTruckService;

    // 分页搜索接口 (已经实现)
    @PostMapping("/search")
    public Response<?> searchFoodTrucks(@RequestBody PageRequest pageRequest) {
        return foodTruckService.getFoodTrucksByPage(pageRequest);
    }

    // 通过 ID 获取食品卡车详情
    @GetMapping("/{id}")
    public Response<FoodTruck> getFoodTruckById(@PathVariable Long id) {
        FoodTruck foodTruck = foodTruckService.getFoodTruckById(id);
        if (foodTruck != null) {
            return Response.success(foodTruck);
        } else {
            return Response.failure("Food Truck not found");
        }
    }

    // 获取所有食品类型 (用于前端筛选功能)
    @GetMapping("/food-items")
    public Response<List<String>> getAllFoodItems() {
        return Response.success(foodTruckService.getAllFoodItems());
    }

    // 根据食品类型查询
    @GetMapping("/search-by-food-item")
    public Response<?> searchByFoodItem(@RequestParam String foodItem, @RequestParam int pageNum, @RequestParam int pageSize) {
        return foodTruckService.searchFoodTrucksByFoodItem(foodItem, pageNum, pageSize);
    }

    // 根据申请人(applicant)查询
    @GetMapping("/search-by-applicant")
    public Response<?> searchByApplicant(@RequestParam String applicant, @RequestParam int pageNum, @RequestParam int pageSize) {
        return foodTruckService.searchFoodTrucksByApplicant(applicant, pageNum, pageSize);
    }
}