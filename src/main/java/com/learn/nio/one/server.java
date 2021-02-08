package com.learn.nio.one;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class server {
    public static void main(String[] args) throws Exception{
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2.切换为非阻塞模式
        ssChannel.configureBlocking(false);
        //3.绑定端口
        ssChannel.bind(new InetSocketAddress(9999));
        //4.获取选择器
        Selector selector = Selector.open();
        //5.将通道注册到选择器,并监听接收事件
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        //6.使用选择器轮询已就绪的事件
        while (selector.select()>0){
            //7.获取选择器的所有就绪好的事件
        }
    }
}
