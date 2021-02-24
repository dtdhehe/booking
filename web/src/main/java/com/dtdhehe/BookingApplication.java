package com.dtdhehe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 16:16
 * @description
 **/
@SpringBootApplication
@MapperScan("com.dtdhehe.mapper")
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class,args);
    }

}
