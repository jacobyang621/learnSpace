package com.learn.nio.one;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class client {
    public static void main(String[] args)throws Exception {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9999));
        sChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请说: ");
            String msg = scanner.nextLine();
            byteBuffer.put(("hi"+msg).getBytes());
            byteBuffer.flip();
            sChannel.write(byteBuffer);
            byteBuffer.clear();
        }


    }
}
