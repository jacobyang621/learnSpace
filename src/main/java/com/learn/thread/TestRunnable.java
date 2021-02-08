package com.learn.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestRunnable implements Runnable{
    @Override
    public void run() {
      log.info("running");
    }
}
