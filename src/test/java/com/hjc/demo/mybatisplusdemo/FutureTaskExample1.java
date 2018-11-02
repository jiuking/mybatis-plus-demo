package com.hjc.demo.mybatisplusdemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);
        MyCallable callable3 = new MyCallable(1000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);
        FutureTask<String> futureTask3 = new FutureTask<>(callable3);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);
        executor.execute(futureTask3);

        for (int i = 0; i < 2; i++)

//        while (true)
        {
            try {
                if(futureTask1.isDone() && futureTask2.isDone()){
                    System.out.println("Done");
                    //shut down executor service
                    executor.shutdown();
                    return;
                }

                if(!futureTask1.isDone()){
                    //阻塞futureTask1
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                //阻塞当然时间短，肯定会抛异常当然不会执行下面的语句，而是执行try catch外的语句
                String s = futureTask2.get(5000L, TimeUnit.MILLISECONDS); //阻塞500毫秒
                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
                else{
                    System.out.println("FutureTask2 output is null");
                }
                System.out.println("Futrue task out is everything");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }catch(Exception e){
                //do nothing
                e.printStackTrace();
            }
            System.out.println("线程3"+futureTask3.get());

        }
        executor.shutdown();
//        System.out.println("finish");
    }

}