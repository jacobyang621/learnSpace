package com.learn.bio.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread implements Runnable{
    private Socket socket;

    public MyThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        //获取输入流
        InputStream is = null;
        try {
            is = socket.getInputStream();

        //将字节流包装成字符流，再包装成每行读取
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg;
        while ((msg = br.readLine()) != null) {
            System.out.println("接收: " + msg);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
