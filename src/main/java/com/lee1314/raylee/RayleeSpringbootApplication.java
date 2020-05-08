package com.lee1314.raylee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lee1314.raylee.modules.*.dao.mapper"})
public class RayleeSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RayleeSpringbootApplication.class, args);
    }

}
