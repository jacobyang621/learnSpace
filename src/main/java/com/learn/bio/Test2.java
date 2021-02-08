package com.learn.bio;

import java.io.*;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\new.txt";
        FileInputStream fis = new FileInputStream(path);
        BufferedInputStream bis = new BufferedInputStream(fis);

        FileOutputStream fos =new FileOutputStream("D:\\new2.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] buf = new byte[1024];
        int count = 0;
        while ((count = bis.read(buf))!=-1){
            bos.write(buf,0,count);
            bos.flush();
        }
        bos.close();
        bis.close();
    }
}
