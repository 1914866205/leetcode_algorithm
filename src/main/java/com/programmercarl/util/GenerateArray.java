package com.programmercarl.util;

/**
 * @ClassName GenerateArray
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/13 11:05
 * @Version 1.0
 * 用于根据力扣字符串数组生成数组
 **/
public class GenerateArray {
    public static char[][] generateArrays(String arr) {
        int n = arr.split("],").length;
        char[][] result = new char[n][n];
        StringBuilder tempStr = new StringBuilder("");
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) != '[' && arr.charAt(i) != '"' && arr.charAt(i) != ']' && arr.charAt(i) != ',') {
                tempStr.append(arr.charAt(i));
            }
        }
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = tempStr.charAt(index);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] result = generateArrays("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]\n");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
