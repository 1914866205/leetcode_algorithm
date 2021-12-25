package com.demo.course.help;

import java.util.Scanner;
public class problem13 {

    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int[] nums = new int[n+1];
//        for (int i = 0; i < n; i++) {
//            nums[i] = input.nextInt();
//        }
//        //要询问的给定值个数
//        int m = input.nextInt();
//        int[] value = new int[m];
//        for (int i = 0; i < m; i++) {
//            value[i] = input.nextInt();
//        }
        int[] nums = {-2,-1,0,1,1,1,2,5,6,50,51,52,54,56,70,72};
        int n = nums.length;
        int[] value = {-3, 0, 1, 3, 4, 7, 49, 50, 53, 55, 57, 69, 70, 73};
        int m = value.length;
        int left = 0;
        int right = n-1;
        int mid;
        for (int i = 0; i < m; i++) {
            int des = value[i];
            while (left < right - 1) {
                mid = (right + left) / 2;
                if (des < nums[mid]) right = mid;
                else   left=mid;
            }
            if(Math.abs(nums[left]-des)<=Math.abs(nums[right]-des)){
                System.out.println("距离"+value[i]+"最近的是："+nums[left]);
//                System.out.println(nums[left]);
            }
            else
                System.out.println("距离"+value[i]+"最近的是："+nums[left]);
//                System.out.println(nums[right]);
        }
    }
}