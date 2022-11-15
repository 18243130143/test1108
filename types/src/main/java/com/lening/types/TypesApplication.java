package com.lening.types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDiscoveryClient
@MapperScan(basePackages = {"com.lening.types.mapper"})
@SpringBootApplication
public class TypesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TypesApplication.class, args);
    }

}
