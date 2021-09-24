package com.wxy.serviceedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wxy
 * @title: EduApplication
 * @description: TODO
 * @date 2021/9/2115:21
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.wxy")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
