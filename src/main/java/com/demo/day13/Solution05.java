package com.demo.day13;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * author: nitaotao
 * date: 2022/1/2 0:52
 * version: 1.0
 * description: todo
 */
public class Solution05 {
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(solution05.findKthLargest(arr,2));
    }

    public int findKthLargest(int[] nums, int k) {
        //可以给初始大小
        Queue queue = new PriorityQueue();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int result = (int) queue.poll();
            if (i == nums.length-k) {
                return result;
            }
        }
        return 0;
    }
}
