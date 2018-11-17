package com.hjc.demo.mybatisplusdemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;

@Configuration
@Order(0)
public class DataSourceAspect {

    public DataSourceAspect() {
        System.out.println("啥时候初始化！！！222");
    }

//    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
