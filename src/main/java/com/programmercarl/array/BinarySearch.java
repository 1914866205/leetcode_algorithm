package com.programmercarl.array;

/**
 * @ClassName BinarySearch
 * @Descriotion https://leetcode-cn.com/problems/binary-search/
 * @Author nitaotao
 * @Date 2022/5/1 11:52
 * @Version 1.0
 * 704. 二分查找
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(search(nums,13));
        System.out.println(binarySearchByArray(nums,-1));
    }

    public static int search(int[] nums, int target) {
        // 考虑不存在的情况，目标值比最小值小 或 比最大值大
        if (target < nums[0] || (target > nums[nums.length - 1])) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length, target);
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        //1.中间值
        int mid = (end + start) / 2;
        if (target < nums[mid]) {
            return binarySearch(nums, start, mid - 1, target);
        } else if (target > nums[mid]) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return mid;
        }
    }


    public static int binarySearchByArray(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        //1.中间值
        int mid = (end + start) / 2;
        while (start <= end) {
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
            mid = (end + start) / 2;
        }
        return -1;
    }
}
