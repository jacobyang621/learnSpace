package com.learn.proxy;

import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        Hi hi = new Hi();
        HiProxy hiProxy = new HiProxy(hi);
        ClassLoader classLoader = Hi.class.getClassLoader();
        Class<?>[] interfaces = Hi.class.getInterfaces();
        IHi hiproxy = (IHi)Proxy.newProxyInstance(classLoader, interfaces, hiProxy);
        hiproxy.Hi();

    }
}
