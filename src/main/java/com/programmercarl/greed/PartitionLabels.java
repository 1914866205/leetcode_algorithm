package com.programmercarl.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PartitionLabels
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/17 11:40
 * @Version 1.0
 * https://leetcode.cn/problems/partition-labels/
 * 763. 划分字母区间
 **/
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        int end = 1;
        //此时end为最后出现的首字母位置
        for (int i = 0; i < s.length(); ) {
            //找到最后出现的首字母的位置end
            int k = i;
            for (; k < s.length(); k++) {
                if (s.charAt(k) == s.charAt(i)) {
                    end = k;
                }
            }
            String temp = s.substring(i, end + 1);

            for (int j = end + 1; j < s.length(); j++) {
                if (temp.indexOf(s.charAt(j)) != -1) {
                    //如果之后还出现在[0,end]区间之外有内部元素
                    temp = s.substring(i, j+1);
                    end = j;
                }
            }
            result.add(end - i + 1);
            i = end + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
