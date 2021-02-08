package com.learn.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.concurrent.Callable;
@Slf4j
public class TestCallable implements Callable {
    @Override
    public Object call() throws Exception {
        log.info("running");
        return new HashMap<>();
    }
}
