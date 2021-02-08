package com.learn.thread;

public class ImplementsRunnable {
    public static void main(String[] args) {
        Thread t = new Thread(new TestRunnable(),"t1");
        t.start();
        t.start();
        
    }
}
