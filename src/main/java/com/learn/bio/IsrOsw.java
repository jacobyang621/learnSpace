package com.learn.bio;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class IsrOsw {
    public static void main(String[] args) throws Exception{
        String path ="D:\\new.txt";
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");

    }
}
