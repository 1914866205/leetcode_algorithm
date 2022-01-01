package com.demo.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: nitaotao
 * date: 2022/1/1 21:16
 * version: 1.0
 * description: todo
 */
public class Solution02 {
    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] nums = {-1,0,1,2,-1,-4};
        solution02.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        String resultStr = "";
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < nums.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if ((nums[i] + nums[j] + nums[k]) == 0) {
                        int[] temp = new int[3];
                        temp[0] = nums[i];
                        temp[1] = nums[j];
                        temp[2] = nums[k];
                        Arrays.sort(temp);
                        String str = "";
                        for (int l = 0; l < temp.length; l++) {
                            str += temp[l];
                        }

                        //如果没有包含
                        boolean flag = true;
                        String[] split = resultStr.split("\\*");
                        for (int l = 0; l < split.length; l++) {
                            if (split[l].equals(str)) {
                                flag = false;
                            }
                        }
                        if (flag) {
                            resultStr += str + "*";
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                        }
                    }
                }
            }
        }
        System.out.println(resultStr);
        return result;
    }
}
