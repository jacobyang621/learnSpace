package com.learn.bio.three;

import java.net.ServerSocket;
import java.net.Socket;

public class server2 {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);

        while (true){
            System.out.println("kaishi");
            Socket socket = serverSocket.accept();
            new Thread(new MyThread(socket)).start();
        }
    }
}
