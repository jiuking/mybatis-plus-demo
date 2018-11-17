package com.hjc.demo.mybatisplusdemo.conf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.AsyncAnnotationAdvisor;
import org.springframework.stereotype.Component;

@Configuration
@Order(10000)
public class AsyncAnnotationAdivorS   {
    public AsyncAnnotationAdivorS() {
        System.out.println("初始化");
    }

//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) {
//        super.setBeanFactory(beanFactory);
//        System.out.println("初始化快快快1111");
//    }

    public int getOrder() {
        return 0;
    }


}
