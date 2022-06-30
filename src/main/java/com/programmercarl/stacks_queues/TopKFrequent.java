package com.programmercarl.stacks_queues;

import lombok.val;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName TopKFrequent
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/6/30 14:13
 * @Version 1.0
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 **/
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        /**
         * 思路：
         * 哈希表计数
         */
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int[] keys = new int[map.size()];
        int[] values = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            keys[index] = key;
            values[index] = map.get(key);
            index++;
        }
        //value 排序，key 镜像同步交换
        for (int i = 0; i < values.length-1; i++) {
            for (int j = i+1; j < values.length; j++) {
                if (values[i] < values[j]) {
                    int tempValue = values[i];
                    values[i] = values[j];
                    values[j] = tempValue;

                    int tempKey = keys[i];
                    keys[i] = keys[j];
                    keys[j] = tempKey;
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keys[i];
        }
        return result;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        /**
         * 思路：
         * 哈希表计数
         */
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        //大顶堆思想
        //优先级队列，按值大小排序
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        for(Map.Entry<Integer,Integer>entry : map.entrySet()) {
            queue.offer(entry);
            //只保留前k个数
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }
}
