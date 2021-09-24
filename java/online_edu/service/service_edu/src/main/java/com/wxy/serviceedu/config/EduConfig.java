package com.wxy.serviceedu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wxy
 * @title: EduConfig
 * @description: TODO
 * @date 2021/9/2115:25
 */
@Configuration
@MapperScan("com.wxy.serviceedu.mapper")
public class EduConfig {

    /**
    　　* @description: 配置逻辑删除插件
    　　* @author wxy
    　　* @date 2021/9/21 15:38
    　　*/
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }
}
