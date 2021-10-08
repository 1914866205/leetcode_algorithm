package com.demo.day02;

import java.util.Scanner;

public class PrintText {
    // print a text containing no spaces
    public static void printText(String text) {
        System.out.println("text"+text);
    }

    public static void main(String[] args) {
        // test the method above with a text input from keyboard
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        printText(text);
    }
}

