package com.wxy.serviceedu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxy
 * @title: MybatisPlusConfig
 * @description: TODO
 * @date 2021/9/2220:24
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor(){return new PaginationInterceptor();}
}
