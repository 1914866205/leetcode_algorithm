package com.programmercarl.array;

/**
 * @ClassName MinimumSizeSubarraySum
 * @Descriotion https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * @Author nitaotao
 * @Date 2022/5/1 15:52
 * @Version 1.0
 * 209.长度最小的子数组
 **/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    /**
     * 直接暴力解法
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        //初始化最小长度
        //此处不能为总长度，因为有可能全部和起来才刚好符合条件
        int min = nums.length + 1;
        //如果只有一个元素
        if (min == 1) {
            if (nums[0] >= target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            //如果不止一个元素
            //总和 初始值
            for (int i = 0; i < nums.length; i++) {
                int sum = nums[i];
                if (sum >= target) {
                    return 1;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        //为什么要+1呢？
                        //因为作为j是不能直接取到最后一位的， j的范围其实是 [1,nums.length-1]
                        //此处可以理解为  min > (j + 1 ) -i
                        //这里是最后一位，就是 nums.length , 即 j + 1
                        if (min > j - i + 1) {
                            min = j - i + 1;
                        }
                        // 本轮循环结束
                        break;
                    }
                }
            }
            if (min == nums.length + 1) {
                return 0;
            }
            return min;
        }

    }

    /**
     * 双指针法
     *
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLenByPoint(int target, int[] nums) {
        //初始最短化为不可能的数
        int min = nums.length + 1;
        //头指针
        int startPoint = 0;
        //尾指针
        int endPoint = 0;
        //总和
        int sum = 0;
        for (; endPoint < nums.length; endPoint++) {
            //以尾指针计,左开右闭
            sum += nums[endPoint];
            //如果当前总和比目标值大
            while (sum >= target) {
                sum -= nums[startPoint];
                //计算当前长度，再和最短长度比较
                if (min > endPoint + 1 - startPoint) {
                    min = endPoint + 1 - startPoint;
                }
                //头指针后移
                startPoint++;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}
