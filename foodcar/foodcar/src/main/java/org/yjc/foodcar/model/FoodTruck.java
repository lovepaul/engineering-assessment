package org.yjc.foodcar.model;
import lombok.Data;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("mobile_food_facility_permit")  // 对应数据库中的表名
public class FoodTruck {

    @TableId(value = "location_id", type = IdType.AUTO)  // 主键字段，使用自增
    private Long locationId;

    private String applicant;
    private String facilityType;
    private Long cnn;
    private String locationDescription;
    private String address;
    private String blocklot;
    private String block;
    private String lot;
    private String permit;
    private String status;
    private String foodItems;
    private String x;
    private String y;
    private Double latitude;
    private Double longitude;
    private String schedule;
    private String daysHours;
    private String noiSent;
    private String approved;
    private String received;
    private Integer priorPermit;
    private String expirationDate;
    private String location;
    private Integer firePreventionDistricts;
    private Integer policeDistricts;
    private Integer supervisorDistricts;
    private Float zipCodes;
    private Float neighborhoodsOld;
}