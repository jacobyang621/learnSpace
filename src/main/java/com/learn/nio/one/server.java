package com.learn.nio.one;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class server {
    public static void main(String[] args) throws Exception{
        System.out.println("开始启动");
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
            System.out.println("开始事件处理");
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            //8.遍历所得事件
            while (iterator.hasNext()){
                SelectionKey sk = iterator.next();
                //9.当事件为链接时，新建链接
                if(sk.isAcceptable()){
                    System.out.println("开始处理链接");
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector,SelectionKey.OP_READ);
                //10.当事件为准备读取时，读取
                }else if(sk.isReadable()){
                    System.out.println("开始处理数据");
                    SocketChannel channel = (SocketChannel) sk.channel();
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len=channel.read(buf))>0){
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
