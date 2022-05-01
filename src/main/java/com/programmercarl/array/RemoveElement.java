package com.programmercarl.array;

/**
 * @ClassName RemoveElement
 * @Descriotion https://leetcode-cn.com/problems/remove-element/submissions/
 * @Author nitaotao
 * @Date 2022/5/1 13:43
 * @Version 1.0
 * 27 移除元素
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        for (int i = 0; i <length ; i++) {
            if (nums[i] == val) {
                nums[i] = nums[length-1];
                nums[length-1] = 0;
                i--;
                length--;
            }
        }
        return length;
    }
}
