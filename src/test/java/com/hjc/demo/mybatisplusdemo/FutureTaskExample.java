package com.hjc.demo.mybatisplusdemo;

import java.util.concurrent.*;

public class FutureTaskExample {
    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(1000);
        MyCallable callable2 = new MyCallable(2000);

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(futureTask1);
        executor.execute(futureTask2);

        while (true)
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
                System.out.println("阻塞主线程："+Thread.currentThread().getName());
//                if(!futureTask2.isDone()){
                    //阻塞futureTask2
                    System.out.println("FutureTask2 output="+futureTask2.get());
//                }

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }catch(Exception e){
                //do nothing
            }
            System.out.println("所有的全部完成");
        }

    }

}

class MyCallable implements Callable<String> {

    private long waitTime;

    public MyCallable(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }

}
