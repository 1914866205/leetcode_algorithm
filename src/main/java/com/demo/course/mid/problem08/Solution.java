package com.demo.course.mid.problem08;
/**
 * author: nitaotao
 * date: 2021/12/22 16:15
 * version: 1.0
 * description: todo
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //                     0  1  0  1  1  2  2  3  3  4
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
//        先写出数组元素<=2时的情况；
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
//        当数组元素大于2时，找到数组最大元素
        int index = 1;
        int temp;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            //如果到了最大值，则退出
            if (nums[i] == max) {
                break;
            }
            //如果当前位置和前一个位置相同，就把它挪到最后面
            while (nums[i] == nums[i + 1]) {
                for (int k = i + 1; k < nums.length - 1; k++) {
                    temp = nums[k];
                    nums[k] = nums[k + 1];
                    nums[k + 1] = temp;
                }
            }
            index++;
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println(" " + i);
//            System.out.println();
        }
        return index;
    }
}
