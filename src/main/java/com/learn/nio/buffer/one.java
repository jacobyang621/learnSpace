package com.learn.nio.buffer;

import java.nio.ByteBuffer;

public class one {
    public static void main(String[] args) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");

        byteBuffer.put((byte) 1);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");

        byteBuffer.put((byte) 4);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");
        byteBuffer.mark();

        byteBuffer.put((byte) 12);
        System.out.println(byteBuffer.capacity());
        System.out.println(byteBuffer.limit());
        byteBuffer.reset();
        System.out.println(byteBuffer.position());
        System.out.println("---------------------");

       /* byteBuffer.flip();
        System.out.println(byteBuffer.limit());
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get()+",");
        }
        System.out.println("");
        System.out.println("---------------------");
        byteBuffer.clear();
        System.out.println(byteBuffer.limit());
        while (byteBuffer.hasRemaining()){
            System.out.print(byteBuffer.get()+",");
        }*/
    }
}
