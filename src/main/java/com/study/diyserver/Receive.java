package com.study.diyserver;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName Receive
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/5/5 9:32
 * @Version 1.0
 * 本类取得了浏览器传过来的URL字符串
 **/
public class Receive {
    private InputStream in = null;

    public Receive(InputStream in) {
        this.in = in;

    }

    //这个方法的目的是将URL的请求的文件返回
    public String parse() {
        //这个变量就是实际从浏览器获取的请求数据流
        StringBuffer receiveStr = new StringBuffer(2048);
        int i;
        byte[] bytes = new byte[2048];
        try {
            i = in.read(bytes);

        } catch (IOException e) {
            i = -1;
            e.printStackTrace();
        }
        for (int j = 0; j < i; j++) {
            //将取得的信息循环追加到receiveStr变量中
            //此处不填 char ，会是数字
            receiveStr.append((char)bytes[j]);
        }
        return getUri(receiveStr.toString());

    }

    //将收到的HTTP协议数据包分解，取出文件名的描述URL
    private String getUri(String receiveStr) {
        System.out.println("===============receiveStr===================");
        System.out.println(receiveStr);
        System.out.println("===============receiveStr===================");
        int index1, index2;
        index1 = receiveStr.indexOf(' ');
        if (index1 != -1) {
            index2 = receiveStr.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return receiveStr.substring(index1 + 1, index2);
            }
        }
        return null;
    }
}
