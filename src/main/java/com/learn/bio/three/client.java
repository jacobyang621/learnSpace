package com.learn.bio.three;

import lombok.extern.slf4j.Slf4j;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

@Slf4j
public class client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 9999);
        OutputStream os = socket.getOutputStream();
        PrintStream ps = new PrintStream(os);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请说: ");
            String s = scanner.nextLine();
            ps.println(s);
            ps.flush();
        }
    }
}
