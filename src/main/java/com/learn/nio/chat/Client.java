package com.learn.nio.chat;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Client {
    private static final String ip = "127.0.0.1";
    private static final int port = 9999;
    private SocketChannel sChannel;
    private Selector selector;

    public Client() {
        try {
            selector = Selector.open();
            sChannel = SocketChannel.open(new InetSocketAddress(ip, port));
            sChannel.configureBlocking(false);
            sChannel.register(selector, SelectionKey.OP_READ);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        var client = new Client();
        var selector = client.selector;
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (selector.select() > 0) {
                                var iterator = selector.selectedKeys().iterator();
                                while (iterator.hasNext()) {
                                    var sk = iterator.next();
                                    if(sk.isReadable()) {
                                        var channel = (SocketChannel) sk.channel();
                                        var byteBuffer = ByteBuffer.allocate(1024);
                                        channel.read(byteBuffer);
                                        new String(byteBuffer.array()).trim();
                                    }
                                    iterator.remove();
                                }

                            }
                        }catch (Exception e){

                        }

                    }
                }
        ).start();
    }
}
