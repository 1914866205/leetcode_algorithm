package com.demo.day02;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Keep12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double num = scanner.nextDouble();
//        Double num = 3.1415926535798932;
        num = new BigDecimal(num).setScale(12, BigDecimal.ROUND_HALF_DOWN).doubleValue();
        DecimalFormat df = new DecimalFormat("#.000000000000");
        System.out.print("保留12位小数后结果为：" +df.format(num) );
    }
}

