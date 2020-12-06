package com.dkliu.vlog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Hinoki
 */
@SpringBootApplication
@MapperScan("com.dkliu.vlog.mapper")
public class VlogApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VlogApiApplication.class, args);
    }

}