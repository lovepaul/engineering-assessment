package org.yjc.foodcar.common;



import lombok.Data;

@Data
public class PageRequest {
    private int pageNum = 1;  // 默认第一页
    private int pageSize = 10; // 默认每页10条记录
    private String applicant; // 可选查询参数
    private String foodItem;  // 可选查询参数
}
