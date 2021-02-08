package com.learn.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class Server {
    private ServerSocketChannel ssChannel;
    private Selector selector;
    private static final int port = 9999;

    public Server() {
        try {
            ssChannel = ServerSocketChannel.open();
            selector = Selector.open();
            ssChannel.bind(new InetSocketAddress(port));
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var server = new Server();
        server.listen();
    }

    private void listen() {
        try {
            while (selector.select() > 0) {
                var iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    var sk = iterator.next();

                    if (sk.isAcceptable()) {
                        var schannel = ssChannel.accept();
                        schannel.configureBlocking(false);
                        schannel.register(selector, SelectionKey.OP_READ);
                    } else if (sk.isReadable()) {
                        readBuffer(sk);
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {

        }
    }

    private void sendMessage(String s, SocketChannel schannel) throws IOException {
        var iterator = selector.selectedKeys().iterator();
        while (iterator.hasNext()) {
            var sk = iterator.next();
            var channel = (SocketChannel) sk.channel();
            if (channel != schannel) {
                var byteBuffer = ByteBuffer.wrap(s.getBytes());
                channel.write(byteBuffer);
            }
        }
    }

    private void readBuffer(SelectionKey sk) {
        SocketChannel schannel = null;
        try {
            var byteBuffer = ByteBuffer.allocate(1024);
            schannel = (SocketChannel) sk.channel();
            var count = schannel.read(byteBuffer);
            if (count > 0) {
                byteBuffer.flip();
                var s = new String(byteBuffer.array(), 0, byteBuffer.remaining());
                System.out.println("客户端消息：" + s);
                sendMessage(s, schannel);
            }
        }catch (Exception e){
            try {
                sk.cancel();
                schannel.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
