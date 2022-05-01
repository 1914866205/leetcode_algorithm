package com.programmercarl.array;

/**
 * @ClassName SquaresOfASortedArray
 * @Descriotion https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @Author nitaotao
 * @Date 2022/5/1 14:01
 * @Version 1.0
 * 977.有序数组的平方
 **/
public class SquaresOfASortedArray {

    //[-4,-1,0,3,10]
    public int[] sortedSquares(int[] nums) {
        //只有一个元素
        if (nums.length == 1) {
            return new int[]{nums[0] * nums[0]};
        }
        int[] result = new int[nums.length];
        //全为负数
        if (nums[nums.length - 1] < 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                result[nums.length - 1 - i] = nums[i] * nums[i];
            }
            return result;
        } else if(nums[0]>0){
            //全为非负数
            for (int i = 0; i < nums.length; i++) {
                result[i] = nums[i] * nums[i];
            }
            return result;
        }
        //找到正负分界线，此索引前所有位置都是负数
        int index = 0;
        while (nums[index] < 0) {
            index++;
        }
        int point = 0;//result下标指针
        int leftPoint = index - 1;//负数指针，本指针之前全为负数
        int rightPoint = index;//非负指针
        while (leftPoint >= 0 && rightPoint <= nums.length - 1) {
            //最大负数的绝对值和最小非负数比较大小
            if (-nums[leftPoint] > nums[rightPoint]) {
                //负数绝对值比正数大
                result[point] = nums[rightPoint] * nums[rightPoint];
                rightPoint++;
            } else {
                //正数比负数绝对值大
                result[point] = nums[leftPoint] * nums[leftPoint];
                leftPoint--;
            }
            point++;
        }
        //比完之后，要么负数遍历完了，要么非负数遍历完了
        if (leftPoint == -1) {  //如果是负数遍历完了
            // 则剩下的非负数按顺序添加到目标数组
            //负数绝对值比正数大,且此时已无正数
            while (point < nums.length) {
                result[point] = nums[rightPoint] * nums[rightPoint];
                rightPoint++;
                point++;
            }
        } else {
            //正数比负数绝对值大,且此时已无负数
            while (point < nums.length) {
                result[point] = nums[leftPoint] * nums[leftPoint];
                leftPoint--;
                point++;
            }
        }
        return result;
    }
}
