package com.programmercarl.hashtable;

import java.util.*;

/**
 * @ClassName Sum4
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/23 13:35
 * @Version 1.0
 * https://leetcode.cn/problems/4sum/
 * 18. 四数之和
 **/
public class Sum4 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //至少四个数
        if (nums.length > 3) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 3; i++) {
                //升序，如果最小的都比目标值大，那还找啥
                if (nums[i] > target && nums[i] >= 0) {
                    break;
                }
                // i 为基准
                if (i > 0 && i < nums.length - 3 && nums[i] == nums[i - 1]) {
                    continue;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    int left = j + 1;
                    int right = nums.length - 1;
                    System.out.println(i + " " + j);
                      // j 为第二个元素基准
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        System.out.println("第二个元素和之前的重复，跳过本次循环");
                        System.out.println(i + " " + j + " " + left + " " + right);
                        continue;
                    }

                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        System.out.println(i + " " + j + " " + left + " " + right);
                        System.out.println("和为" + sum);
                        if (sum == target) {
                            System.out.println("等于目标值");
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            System.out.println(result);
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                            System.out.println(i + " " + j + " " + left + " " + right);
                        } else if (sum < target) {
                            left++;
                            System.out.println("小于目标值，左指针加加");
                        } else if ((sum > target)) {
                            right--;
                            System.out.println("大于目标值，右指针减减");
                        }
                    }

                    System.out.println(i + " " + j);
                }
                System.out.println(i);
            }
        }
        return result;
    }
}
