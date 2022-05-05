package com.study.diyserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName HttpServer
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 8:38
 * @Version 1.0
 * 建立一个Socket并用死循环的形式监听指定端口
 **/
public class HttpServer {
    public static String ROOT = "src/main/resources";
    //默认ROOT文件夹
    public static String defaultPage = "index.html";

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        while (true) {
            //阻塞：等待浏览器的连接
            Socket sk = server.accept();
            System.out.println("等待连接...");
            //启动服务线程
            new HttpThread(sk).start();

        }
    }
}
