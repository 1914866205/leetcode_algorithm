package com.demo.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: nitaotao
 * date: 2022/1/2 9:03
 * version: 1.0
 * description: https://leetcode-cn.com/problems/3sum/
 */

public class Solution02Study {

    /**
     * threeSum方法：返回nums数组中所有和为0的不重复三元组
     *
     * @param nums 待查找的int数组
     * @return 无重复的三元组列表，每一个元素是一个和为0的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        //仅考虑nums至少包含三个元素的情况
        if (n >= 3) {
            Arrays.sort(nums);   //排序，升序
            int first; //数组的第一个元素下标
            int last; //数组的最后一个元素下标
            // sum =nums[i] + nums[first]+nums[last]
            int sum;
            for (int i = 0; i < nums.length - 2; i++) {
                // 如果当前nums[i]>0,无需继续循环，因为数组为升序
//                nums[i]+nums[first]+nums[last] 肯定也大于0，因为最小值大于0
                if (nums[i] > 0) {
                    break;
                }
                //如果当前nums[i]和之前的nums[i-1]相同，代表这个值已经使用过了，应进入下一个循环，找出没被使用的nums[i]
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                //此时的nums[i]所代表的值为首次使用
                first = i + 1; //初始化first
                last = n - 1; //初始化last
                // first 向后移动，last向前移动，直至两者相遇
                while (first < last) {
                    //获得当前三元组的和
                    sum = nums[i] + nums[first] + nums[last];
                    //当前组的和为0时
                    if (sum == 0) {
                        //添加结果
                        result.add(Arrays.asList(nums[i], nums[first], nums[last]));
                        //然后,让first向后移动，直至移动到一个新值
                        while (first < last && nums[first] == nums[first + 1]) {
                            first++;
                        }
                        first++; //此时first指向一个新的值
                        //last向前移动，直至移动到一个新值
                        while (first < last && nums[last] == nums[last - 1]) {
                            last--;
                        }
                        last--;//此时last指向一个新的值
                    }
                    //当三元组之和<0，first应该向后移动找一个更大的值
                    else if (sum < 0) {
                        first++;
                    } else {
                        //当三元组之和>0，last应该向前移动找一个更小的值
                        last--;
                    }
                }
            }
        }
        return result;
    }
}
