package com.demo.day12;

/**
 * author: nitaotao
 * date: 2021/12/25 12:22
 * version: 1.0
 * description: todo
 */
public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        byte[] bytes = s.getBytes();
        s = "";
        //处理字符串
        for (int i = 0; i < bytes.length; i++) {
            //取出所有的数字数字
            if ((bytes[i] > 47 && bytes[i] < 58)) {
                s += Character.toString((char) bytes[i]);
            }
            //取出所有的字母并转小写
            if ((bytes[i] > 64 && bytes[i] < 91) || (bytes[i] > 96 && bytes[i] < 123)) {
                s += Character.toString((char) bytes[i]).toLowerCase();
            }
        }
        System.out.println(s);
        // s长度为1时恒成立，长度为2时，只要删除一个字符，也能构成
        if (s.length() == 1) {

            return true;
        }else if (s.length()==2){
            if (s.charAt(0) == s.charAt(1)) {
                return true;
            } else {
                return false;
            }
        }else  if (s.length()==3){
            if (s.charAt(0) == s.charAt(2)) {
                return true;
            } else {
                return false;
            }
        }

        String[] arr = s.split("");
        if (s.length() == 3) {
            if (arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[2].equals(arr[0])) {
                return true;
            } else {
                return false;
            }
        }
        for (int i = 0; i < arr.length / 2; i++) {
            //两边逐个开始比较
            if (arr[i].equals(arr[arr.length - 1 - i])) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

}
