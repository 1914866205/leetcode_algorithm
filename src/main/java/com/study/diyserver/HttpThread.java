package com.study.diyserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName HttpThread
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 9:22
 * @Version 1.0
 * 实现一个多线程的程序，用来处理每一个用户的请求
 **/
public class HttpThread extends Thread {
    private Socket socket;

    public HttpThread(Socket sk) {
        this.socket = sk;
    }

    @Override
    public void run() {

        InputStream ins = null;
        OutputStream outs = null;
        try {
            ins = socket.getInputStream();
            outs = socket.getOutputStream();
            Receive receive = new Receive(ins);
            //用Receive类获取浏览器发来的URL请求
            String URL = receive.parse();
            System.out.println("URL:"+URL);
            if ("/".equals(URL)) {
                //如果没有指定文件，那么给传来的URL加上默认文件名
                URL = HttpServer.defaultPage;
            }
            System.out.println("URL:"+URL);
            Answer ans = new Answer(outs);
            //再将URL执行的文件用Answer类的send方法返回给浏览器
            ans.Send(URL);
        } catch (IOException e) {
            System.out.println(e.toString());
        }finally{
            try {
                if (ins != null) {
                    ins.close();
                }
                if (outs != null) {
                    outs.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e){} {

            }
        }

    }
}
