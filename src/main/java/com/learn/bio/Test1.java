package com.learn.bio;

import java.io.*;

public class Test1 {
    private static String path ="D:\\new.txt";
    public static void main(String[] args) throws Exception{
        Reader isr = new InputStreamReader(new FileInputStream(path));
        int cr;
        while ((cr=isr.read())!=-1){
            System.out.println(cr);
        }
    }
}
