package com.programmercarl.hashtable;

import java.util.*;

/**
 * @ClassName sum3
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/21 15:03
 * @Version 1.0
 **/
public class sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //数组长度
        int len = nums.length;
        if (len < 3) {
            return result;
        }

        //先排序
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            //每一位进行比较
            // 如果最小的都比0大，则返回
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    //结果加入结果集
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //数组的长度
        int len = nums.length;
        //当数组的长度小于3时，直接退出
        if (len < 3) {
            return result;
        }
        //将数组排序，升序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            //如果遍历的起始元素大于0，则直接退出
            //因为是升序的，说明最小值都大于0，直接结束
            if (nums[i] > 0) {
                break;
            }
            //去重，当起始的值等于前一个元素，那么得到的结果将会与前一次相同。
            /**
             * 诸如 -1 -1 2
             * 只用计算第一个-1的，会把第二个-1计入
             * 再以第二个-1计算时，在多代入第一个就重复了。
             */
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //左指针
            int left = i + 1;
            //右指针
            int right = len - 1;
            //当左不等于右时
            while (left < right) {
                //三数相加
                int sum = nums[i] + nums[left] + nums[right];
                //如果等于0，则加入结果集
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //将左右指针移动时，先对左右指针的值进行判断，重复则跳过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    //去重，因为 i不变，当此时 r 取的数的值与前一个相同，所以不用在计算
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //当左边和右边都不在和前一个相同时
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        /**
         * 依旧可以使用hashmap，
         * 三数之和，其实当前两个数确定时，最后一个数已经确定了。
         * 可以把前两数获取到，再计算最后一个数，为防止一样，三数排序作为键
         */
        List<List<Integer>> result = new ArrayList<>();
        int temp;
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                //第三个数
//                temp = 0 - nums[i] - nums[j];
                temp = -(nums[i] + nums[j]);
                //三数排序,降序
                String key = order3(nums[i], nums[j], temp);
                map.put(key, i + "#" + j + "=" + temp);
            }
        }
        //只有出现过的才算正确
        Set<String> set = new HashSet<>();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            for (int i = 0; i < nums.length; i++) {
                //值
                String valStr = map.get(key);
                //当前被比较的值，不一定存在
                int value = Integer.parseInt(valStr.split("=")[1]);
                if (value == nums[i]) {
                    //再判断这个数是不是自己
                    //如果不是，再添加
                    //位置进行比较
                    //位置
                    String[] pos = valStr.split("=")[0].split("#");
                    if (!(pos[0].equals(String.valueOf(i)) || pos[1].equals(String.valueOf(i)))) {
                        set.add(key);
                    }
                }
            }
        }
        //处理结果集,去重
        for (String res : set) {
            List<Integer> resultList = new ArrayList<>();
            String[] split = res.split("#");
            resultList.add(Integer.valueOf(split[0]));
            resultList.add(Integer.valueOf(split[1]));
            resultList.add(Integer.valueOf(split[2]));
            result.add(resultList);
        }
        return result;
    }

    /**
     * 三数降序排序
     *
     * @param nums1
     * @param nums2
     * @param nums3
     * @return
     */
    public static String order3(int nums1, int nums2, int nums3) {
        if (nums1 > nums2) {
            if (nums1 > nums3) {
                //nums1最大
                if (nums2 > nums3) {
                    return "" + nums1 + "#" + nums2 + "#" + nums3;
                } else {
                    return "" + nums1 + "#" + nums3 + "#" + nums2;
                }
            } else {
                //nums1没nums3大
                return "" + nums3 + "#" + nums1 + "#" + nums2;
            }
        } else {
            //nums2>nums1
            if (nums2 > nums3) {
                if (nums1 > nums3) {
                    return "" + nums2 + "#" + nums1 + "#" + nums3;
                } else {
                    return "" + nums2 + "#" + nums3 + "#" + nums1;
                }
            } else {
                //nums1最大
                return "" + nums3 + "#" + nums2 + "#" + nums1;
            }
        }
    }
}
