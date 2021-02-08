package com.learn.bio.three;

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
        new Thread(() -> {
            while (true) {
                Socket s = null;
                try {
                    s = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Socket socket =s;
                new Thread(
                        () -> {
                            System.out.println("kaishi");
                            //阻塞直到收到链接请求
                            try {
                                //获取输入流
                                InputStream is = socket.getInputStream();
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
                ).start();


            }
        }).start();

    }
}
