package com.study.diyserver;

import java.io.*;

/**
 * @ClassName Answer
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 9:53
 * @Version 1.0
 **/
public class Answer {
    private OutputStream outs;

    public Answer(OutputStream outs) {
        this.outs = outs;
    }
    public void Send(String pagefile) throws IOException {
        byte[] bytes = new byte[2048];
        FileInputStream fis = null;
        File file = new File(HttpServer.ROOT, pagefile);
        System.out.println(file.getPath());
        if (file.exists()) {
            fis = new FileInputStream(file);
            int ch = fis.read(bytes, 0, 2048);
            String sBody = new String(bytes, 0);
            //返回的信息是在文件内容前面加上HTTP协议的格式内容
            String sendMessage = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type:text/html\r\b" +
                    "Content-Length:" + ch + "\r\n" +
                    "\r\n" + sBody;
            //输出文件
            outs.write(sendMessage.getBytes());
        } else {
            //文件不存在的话，就返回HTTP协议格式内容
            String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                    "Content-Type:text/html\r\b" +
                    "Content-Length: 23\r\n" +
                    "\r\n" +
                    "<h1>File Not Found</h1>";
            outs.write(errorMessage.getBytes());
        }
        if (fis != null) {
            fis.close();
        }
    }
}
