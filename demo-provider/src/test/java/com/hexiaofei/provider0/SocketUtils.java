package com.hexiaofei.provider0;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SocketUtils {

    public static void serverBIO() throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8989);
        Socket socket ;
        InputStream inputStream = null;
        ExecutorService es1 = Executors.newFixedThreadPool(5);
        while((socket= ss.accept())!=null) {
            System.out.println("client coming……");
            inputStream = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));

            System.out.println("wait read!");


            es1.execute(new Runnable() {
                @Override
                public void run() {
                    String s = null;
                    try {
                        while ((s = bf.readLine()) != null) {
                            System.out.println("start reading ……");
                            TimeUnit.SECONDS.sleep(10);
                            System.out.println(s);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            if(false)
            bf.close();
        }
        inputStream.close();
        socket.close();
    }

    public static void serverBIO1() throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(8989);
        Socket socket ;
        InputStream inputStream = null;
        ExecutorService es1 = Executors.newFixedThreadPool(5);
        while((socket= ss.accept())!=null) {
            InetAddress ia = socket.getInetAddress();
            String adr = ia.getHostAddress();

            System.out.println(adr+": client coming……");
            inputStream = socket.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(adr+": wait read!");
            String s = null;
            while ((s = bf.readLine()) != null) {
                System.out.println(adr+": start reading ……");
                System.out.println(adr+": "+s);
            }

            if(false)
            bf.close();
        }
        inputStream.close();
        socket.close();
    }



    public static void serverNIO() throws IOException {
        ServerSocket ss = new ServerSocket(8989);
        Socket socket ;
        socket = ss.accept();

    }
    public static void client(String name) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",8989);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        for(int i = 0 ; i < 20000000 ; i++)
        bufferedWriter.write(name+"： hello world!\n");
        bufferedWriter.close();
        outputStream.close();
        socket.close();
    }
}
