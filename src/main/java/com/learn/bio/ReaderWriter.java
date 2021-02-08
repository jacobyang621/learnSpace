package com.learn.bio;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReaderWriter {
    public static void main(String[] args) throws Exception{
        String path = "D:\\new.txt";
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
  /*      int count = 0;
        char[] buf = new char[2];
        while ((count = br.read())!=-1){
            System.out.print(new String(buf,0,count));
        }*/
        String line = null;
        while ((line = br.readLine())!=null) {
            System.out.println(line);
        }
        br.close();
    }
}
