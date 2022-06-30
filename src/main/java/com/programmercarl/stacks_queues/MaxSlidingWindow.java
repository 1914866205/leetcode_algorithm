package com.programmercarl.stacks_queues;

/**
 * @ClassName MaxSlidingWindow
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/30 15:02
 * @Version 1.0
 * https://leetcode.cn/problems/sliding-window-maximum/
 * 239. 滑动窗口最大值
 **/
public class MaxSlidingWindow {
    /**
     * 暴力解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        /**
         * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
         * 输出：[3,3,5,5,6,7]
         * 共 8 个数，三个一组滑动，可组成 8-3+1 组，即 6 组
         */
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int max = -10000;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }
        return result;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        /**
         * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
         * 输出：[3,3,5,5,6,7]
         * 共 8 个数，三个一组滑动，可组成 8-3+1 组，即 6 组
         */
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        /**
         * 如果当前范围元素的最大值仍然是下一个范围的最大值，则继续用。
         * 此处要判断当前位置是否过了
         */
        int maxValue = -10000;
        for (int j = 0; j < k; j++) {
            if (nums[j] > maxValue) {
                maxValue = nums[j];
            }
        }
        result[0] = maxValue;
        //前k个已经比较过了
        int resIndex = 1;
        //抽象出来，左边界值，中间部分最大值，右边界值
        for (int i = k; i < nums.length; i++) {
            //刚过期的左边界
            int left = nums[i - k];
            int mid = maxValue;
            int right = nums[i];
            //部分优化，防止连续重复数字出现
            //如果left就是那个最大值
            if (left > mid - 1 && left != nums[i - k + 1]) {
                //如果过期，就得重新再找最大值
                maxValue = -10000;
                for (int j = i - k + 1; j < i + 1; j++) {
                    if (nums[j] > maxValue) {
                        maxValue = nums[j];
                    }
                }
            }

            //如果新元素比原来的大
            if (right >= mid) {
                maxValue = right;
            }
            result[resIndex] = maxValue;
            resIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
    }
}
