package com.hjc.demo.mybatisplusdemo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author : Administrator
 * @date : 2018/11/2 0002 18:28
 * @description :
 */
public class ThreadExample13 {public static void main(String[] args) throws InterruptedException {
    ExecutorService threadPool = Executors.newFixedThreadPool(10);
    CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
    for (int i = 1; i <= 10; i++) {
        final int seq = i;
        completionService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(new Random().nextInt(5000));
                return seq;
            }
        });
    }
    long start = System.currentTimeMillis();
    Thread.sleep(1000);
    for (int i = 0; i < 10; i++) {
        System.out.println("asdf"+i);
        System.out.println(System.currentTimeMillis()-start);
    }
    for (int i = 0; i < 10; i++) {
        try {
            System.out.println(completionService.take().get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    System.out.println("这是哪个是");
    threadPool.shutdownNow();
}

}
