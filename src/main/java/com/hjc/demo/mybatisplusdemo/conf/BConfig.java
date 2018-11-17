package com.hjc.demo.mybatisplusdemo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
@Order(1)
@Configuration
public class BConfig {
    @Bean
    public DataSourceAspect bService() {
        System.out.println("BService 加载了");
        return new DataSourceAspect();
    }
}
