package com.study;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlCon {
    public static void main(String[] args) {
        try {
//1、加载驱动 com.mysql.jdbc.Driver是驱动类的路径
            Class.forName("com.mysql.jdbc.Driver");
//2、创建数据库连接对象
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            String url = "jdbc:mysql://localhost:3306/zhihu"; //localhost表示本机 3306为默认端口 test为数据库名称
            String username = "root";  //定义连接数据库的用户名和密码
            String password = "root";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }
}
