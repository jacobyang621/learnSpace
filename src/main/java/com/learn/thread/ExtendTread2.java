package com.learn.thread;

public class ExtendTread2 {
    public static void main(String[] args) {
        TestThread testThread = new TestThread();

        testThread.start();
        testThread.run();
    }
}
