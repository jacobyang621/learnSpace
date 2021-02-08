package com.learn.thread;

public class ExtendThread {
    public static void main(String[] args) {
        Thread t = new Thread("t1"){
            public void run(){
                System.out.println("running");
                System.out.println("inside+began:"+getState());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("inside+end:"+getState());
            };
        };
        System.out.println("main:"+Thread.currentThread().getState());
        t.start();
        System.out.println(t.getId());
        System.out.println(t.getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("outside:"+t.getState());
    }
}
