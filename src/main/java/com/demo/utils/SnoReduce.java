package com.demo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * 格式化同学提交作业命名不规范
 */
public class SnoReduce {
    public static void main(String[] args) {
        String dirPath = "D:\\360MoveData\\Users\\lenovo\\Desktop\\软件工程1班java第一次作业 - 副本";
        File file = new File(dirPath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            Arrays.stream(files).forEach(sno -> {
                if (sno.getName().split("\\.")[0].length() != 12) {
                    System.out.println("命名不规范：" + sno.getName());
                    sno.renameTo(new File(dirPath + "\\" + sno.getName().substring(0, 12) + ".pdf"));
                }
            });
        }
    }
}
