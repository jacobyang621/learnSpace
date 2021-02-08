package com.learn.bio.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//接受多个消息
public class server {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        //创建服务端
        ServerSocket serverSocket = new ServerSocket(9999);
        MyThreadPool myThreadPool = new MyThreadPool(10, 5);
        new Thread(() -> {
            while (true) {
                Socket s = null;
                try {
                    s = serverSocket.accept();
                    Runnable target = new MyRunnableServer(s);
                    myThreadPool.execute(target);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Socket socket =s;

            }
        }).start();

    }
}
