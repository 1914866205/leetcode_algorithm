package com.demo.course.mid.problem08;
/**
 * author: nitaotao
 * date: 2021/12/22 16:15
 * version: 1.0
 * description: 删除有序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 【解题思路】： 先写出数组元素<=2 时的情况；当数组元素大于 2 时，找到数组最大元素，遍历数组每一
 * 位，当 i 位和 i+1 位相同时，第 i+1 为移动到数组尾部，类似冒泡，直到 i 位与 i+1 位不相同，再进行下一
 * 个位置的比较。由于是顺序数组，当匹配到最大元素时，跳出循环，返回 index。
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //                     0  1  0  1  1  2  2  3  3  4
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(nums));
    }

    /**
     * removeDuplicates方法 删除有序数组中的重复项
     * @param nums 被传入的数组
     * @return 返回删除后数组的新长度
     */
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
            //因为数组有序，最大值在最右边。如果到了最大值，则退出
            if (nums[i] == max) {
                break;
            }
            //如果当前位置和后一个位置相同，就把它后一个元素挪到最后面
            //并且后面其他元素依次往前挪一位
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
