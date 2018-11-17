package com.hjc.demo.mybatisplusdemo.conf;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.AsyncAnnotationAdvisor;
import org.springframework.stereotype.Component;

@Component
public class AsyncAnnotationAdivorS extends AsyncAnnotationAdvisor implements Ordered {
    public AsyncAnnotationAdivorS() {
        System.out.println("初始化");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        super.setBeanFactory(beanFactory);
        System.out.println("初始化快快快1111");
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
