package com.demo.day02;

import java.util.Scanner;

public class PrintNum {
    // print four integers which belong to byte, short, int and long, respectively
    public void printInteger(byte var1, short var2, int var3, long var4) {
        System.out.println("byte var1" + var1);
        System.out.println("short var2" + var2);
        System.out.println("int var3" + var3);
        System.out.println("long var4" + var4);
    }

    // print two numbers which belong to float and double, respectively
    public void printDecimal(float var1, double var2) {
        System.out.println("float var1" + var1);
        System.out.println("double var2" + var2);
    }

    // print a character
    public void printChar(char ch) {
        System.out.println("char ch" + ch);
    }

    // print a boolean value
    public void printBoolean(boolean bool) {
        System.out.println("boolean bool" + bool);
    }

    public static void main(String[] args) {
        // test the four methods above with arguments input from keyboard
        PrintNum printNum = new PrintNum();
        Scanner sc = new Scanner(System.in);
        byte a = sc.nextByte();
        short b = sc.nextShort();
        int c = sc.nextInt();
        long d = sc.nextLong();
        float e = sc.nextFloat();
        double f = sc.nextDouble();
        char g = sc.next().charAt(0);
        boolean h = sc.nextBoolean();
        printNum.printInteger(a, b, c, d);
        printNum.printChar(g);
        printNum.printBoolean(h);
        printNum.printDecimal(e, f);
    }
}
