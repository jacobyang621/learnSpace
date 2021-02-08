package com.learn.bio.four;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    private ExecutorService executorService;


    public MyThreadPool(int maxThreadNum,int queueSize) {
        executorService = new ThreadPoolExecutor(3,maxThreadNum,120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable target){
        executorService.execute(target);
    }
}
