package com.cq.springbootdata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(basePackages="com.cq.springbootdata.mapper")
@SpringBootApplication
//用来开启基于注解的缓存
@EnableCaching
public class SpringbootDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataApplication.class, args);
    }

}
