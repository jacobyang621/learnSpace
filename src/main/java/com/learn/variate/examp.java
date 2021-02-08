package com.learn.variate;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class examp {
    static int a = 0;
    static Object o =new Object();

    public static void main(String[] args) {
        log.info("began:"+a);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increde();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                increde();
            }
        }, "t2");
        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            log.info("end:"+a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void increde() {

        try{

            for(int i=0;i<1000000;i++){
                int b = i;
                int c = i++;
                int d=b+c;
            }
            a++;
        }catch (Exception e){

        }finally {
        }


        }
}
