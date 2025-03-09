package com.cg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.cg.mapper")
@SpringBootApplication
public class LabAmApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabAmApplication.class, args);
    }

}
