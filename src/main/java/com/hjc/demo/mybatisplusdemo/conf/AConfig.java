package com.hjc.demo.mybatisplusdemo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
@Order(2)
@Configuration
public class AConfig {
    @Bean
    public DataSourceAspect AService() {
        System.out.println("AService 加载了");
        return new DataSourceAspect();
    }
}
