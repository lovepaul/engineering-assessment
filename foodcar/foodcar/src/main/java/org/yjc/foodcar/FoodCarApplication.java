package org.yjc.foodcar;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.yjc.foodcar.mapper")// 指定Mapper接口所在的包
public class FoodCarApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodCarApplication.class, args);
    }

}
