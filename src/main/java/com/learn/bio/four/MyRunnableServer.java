package com.learn.bio.four;

import java.io.IOException;
import java.net.Socket;

public class MyRunnableServer implements Runnable{
    private Socket socket;

    public MyRunnableServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
