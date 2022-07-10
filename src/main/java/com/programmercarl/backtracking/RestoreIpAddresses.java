package com.programmercarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RestoreIpAddresses
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/10 17:13
 * @Version 1.0
 * https://leetcode.cn/problems/restore-ip-addresses/
 * 93. 复原 IP 地址
 **/
public class RestoreIpAddresses {
    public static void main(String[] args) {
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("0279245587303"));
    }
    List<String> result = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4) {
            return result;
        }
        backtracking(s, "", 0, 0);
        return result;
    }

    public void backtracking(String s, String ip, int startIndex, int pointNums) {
        //已经出现前三个网络号，并且最后的主机号还要有位置
        if (pointNums == 3 && (ip.length() - 3 != s.length())) {
            //  ip    192.168.0.
            String temp = s.substring(ip.length() - 3);
            //不符合条件的数字
            if (temp.charAt(0) == '0' && temp.length() != 1) {
                return;
            }
            if (temp.length() > 3) {
                return;
            }
            if (Integer.parseInt(temp) > 255) {
                return;
            }
            result.add(ip + s.substring(ip.length() - 3));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String temp = s.substring(startIndex, i + 1);
            if (temp.length() > 3) {
                continue;
            }
            //不符合条件的数字
            if (temp.charAt(0) == '0' && temp.length() != 1) {
                continue;
            }
            if (Integer.parseInt(temp) > 255) {
                continue;
            }
            pointNums++;
            //需要i+1,因为不可重复
            backtracking(s, ip + temp + ".", i + 1, pointNums);
            //回溯
            pointNums--;
        }
    }
}
