package com.demo.day12;


/**
 * author: nitaotao
 * date: 2021/12/25 11:18
 * version: 1.0
 * description:  https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Solution01 {
    public static void main(String[] args) {
        Solution01 solution = new Solution01();
        System.out.println(solution.romanToInt("MCDLXXVI"));

    }

    public int romanToInt(String s) {
        int num = 0;
        String[] split = s.split("");
        //判断是不是最后一位是特殊字符 两种情况，最后两位是特殊字符和最后一位是特殊字符
        int i = 0;
        while (i < split.length) {
            //最后两位是特殊字符
            if (i + 1 == split.length - 1) {
                if (split[i].equals("I") && split[i + 1].equals("V")) {
                    num += 4;
                    break;
                } else if (split[i].equals("I") && split[i + 1].equals("X")) {
                    num += 9;
                    break;
                } else if (split[i].equals("X") && split[i + 1].equals("L")) {
                    num += 40;
                    break;
                } else if (split[i].equals("X") && split[i + 1].equals("C")) {
                    num += 90;
                    break;
                } else if (split[i].equals("C") && split[i + 1].equals("D")) {
                    num += 400;
                    break;
                } else if (split[i].equals("C") && split[i + 1].equals("M")) {
                    num += 900;
                    break;
                }
            }
            if (i + 1 == split.length) {
                //如果是最后一位
                if (split[i].equals("I")) {
                    num += 1;
                } else if (split[i].equals("V")) {
                    num += 5;
                } else if (split[i].equals("X")) {
                    num += 10;
                } else if (split[i].equals("L")) {
                    num += 50;
                } else if (split[i].equals("C")) {
                    num += 100;
                } else if (split[i].equals("D")) {
                    num += 500;
                } else if (split[i].equals("M")) {
                    num += 1000;
                }
            } else {
                //如果是特殊字符，取两位
                if (split[i].equals("I") && split[i + 1].equals("V")) {
                    num += 4;
                    i++;
                } else if (split[i].equals("I") && split[i + 1].equals("X")) {
                    num += 9;
                    i++;
                } else if (split[i].equals("X") && split[i + 1].equals("L")) {
                    num += 40;
                    i++;
                } else if (split[i].equals("X") && split[i + 1].equals("C")) {
                    num += 90;
                    i++;
                } else if (split[i].equals("C") && split[i + 1].equals("D")) {
                    num += 400;
                    i++;
                } else if (split[i].equals("C") && split[i + 1].equals("M")) {
                    num += 900;
                    i++;
                } else {
                    if (split[i].equals("I")) {
                        num += 1;
                    } else if (split[i].equals("V")) {
                        num += 5;
                    } else if (split[i].equals("X")) {
                        num += 10;
                    } else if (split[i].equals("L")) {
                        num += 50;
                    } else if (split[i].equals("C")) {
                        num += 100;
                    } else if (split[i].equals("D")) {
                        num += 500;
                    } else if (split[i].equals("M")) {
                        num += 1000;
                    }
                }
            }
            i++;
        }
        return num;
    }
}
