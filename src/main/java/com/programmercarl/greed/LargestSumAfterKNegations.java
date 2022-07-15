package com.programmercarl.greed;

import java.util.Arrays;

/**
 * @ClassName LargestSumAfterKNegations
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/15 17:21
 * @Version 1.0
 * https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
 * 1005. K 次取反后最大化的数组和
 **/
public class LargestSumAfterKNegations {
    public static void main(String[] args) {
//        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{8, -7, -3, -9, 1, 9, -6, -9, 3}, 8));
        System.out.println(new LargestSumAfterKNegations().largestSumAfterKNegations(new int[]{-4, -2, -3}, 4));
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        if (nums.length == 1) {
            return k % 2 == 0 ? nums[0] : -nums[0];
        }
        /**
         * 思路明确：
         * 数组排序，升序
         * 先看有没有负数，如果没有，就把最小非负数直接变 k 次
         * 如果有负数，从最大负数开始变，直接变到0截止
         * 如果变不到非负数，变到哪是哪
         * 如果变到了非负数，且无 0
         * 那就比较最小非负数和最小负数的绝对值，变较小值
         */
        Arrays.sort(nums);
        // 负数的下标
        int index = -1;
        //总和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                index = i;
            } else {
                break;
            }
        }
        if (index == -1) {
            //全是非负数
            for (int i = 1; i < nums.length; i++) {
                sum += nums[i];
            }
            //只对第一位变
            int first = k % 2 == 0 ? nums[0] : -nums[0];
            return sum + first;
        } else {
            //如果有负数
            // k比负数多
            if (k > index + 1) {
                //负数全部变为正数
                for (int i = 0; i < index; i++) {
                    sum -= nums[i];
                }
                //比较最大负数和最小正数
                //下标是从0开始的，所以 一共 index+1个负数
                k = k - index;
                //判断当前最后一个负数是不是数组最后一个数
                if (index != nums.length - 1) {
                    //如果不是最后一位，且后面还有非负数
                    if (nums[index + 1] == 0) {
                        //如果最后一位是0
                        sum -= nums[index];
                        for (int i = index + 1; i < nums.length; i++) {
                            sum += nums[i];
                        }
                        return sum;
                    } else {
                        //如果最后一位不是0
                        //负数最大值
                        int left = nums[index];
                        //正数最小值
                        int right = nums[index + 1];
                        //最后一个k
                        k = k % 2;
                        if (k == 1) {
                            sum -= nums[index];
                            for (int i = index + 1; i < nums.length; i++) {
                                sum += nums[i];
                            }
                            return sum;
                        } else {
                            // k==0
                            // 则最小正数和最大负数得变一个
                            if (-left > right) {
                                //正负各变一次
                                sum -= nums[index];
                                sum -= nums[index + 1];
                                for (int i = index + 2; i < nums.length; i++) {
                                    sum += nums[i];
                                }
                                return sum;
                            } else {
                                //负数单用两次
                                for (int i = index; i < nums.length; i++) {
                                    sum += nums[i];
                                }
                                return sum;
                            }
                        }

                    }

                } else {
                    //则全部为负数
                    int first = k % 2 == 0 ? nums[index] : -nums[index];
                    return sum += first;
                }

            } else {
                //k<=负数
                for (int i = 0; i < k; i++) {
                    sum -= nums[i];
                }
                for (int i = k; i < nums.length; i++) {
                    sum += nums[i];
                }
                return sum;
            }
        }
    }
}
