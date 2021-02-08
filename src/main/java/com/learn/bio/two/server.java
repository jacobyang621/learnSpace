package com.learn.bio.two;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//一直接收消息
public class server {
    public static void main(String[] args) throws Exception{
        System.out.println("服务端启动");
        //创建服务端
        ServerSocket serverSocket = new ServerSocket(9999);
        //阻塞直到收到链接请求
        Socket s = serverSocket.accept();
        //获取输入流
        InputStream is = s.getInputStream();
        //将字节流包装成字符流，再包装成每行读取
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg;
        while ((msg = br.readLine())!=null){
            System.out.println(msg);
        }

    }
}
