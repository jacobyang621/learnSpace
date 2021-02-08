package com.learn.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestSynchronized {
    static Integer counter = 0;
    static Integer i = 0;
    static Object o = new Object();
    public static void main(String[] args) {
        String a;

        log.info("began:"+counter);
        Thread t1 = new Thread(()->{
            synchronized (i) {
                for (int i = 0; i < 5000; i++) {
                    counter++;
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            synchronized (i) {
                for (int i = 0; i < 5000; i++) {
                    counter--;
                }
            }
        },"t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("end:"+counter);
    }
}
