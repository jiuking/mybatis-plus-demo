package com.hjc.demo.mybatisplusdemo.test.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class FileService {
    //测试线程池
    @Async
    public void testthread1(CountDownLatch countDownLatch,int i) {
        System.out.println(i+"---线程名称1：" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }

    @Async
    public void testthread2(CountDownLatch countDownLatch,int i) {
        System.out.println(i+"====线程名称2：" + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
