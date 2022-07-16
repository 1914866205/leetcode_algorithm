package com.programmercarl.greed;

import java.util.HashMap;

/**
 * @ClassName LemonadeChange
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/16 12:20
 * @Version 1.0
 * https://leetcode.cn/problems/lemonade-change/
 * 860. 柠檬水找零
 **/
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }
        HashMap<Integer, Integer> retains = new HashMap<Integer, Integer>();
        for (int i = 0; i < bills.length; i++) {
            // bills只能是 5 10 20
            switch (bills[i]) {
                case 5:
                    // 获取 5 元的数量，在原有的基础上+1
                    retains.put(5, retains.getOrDefault(5, 0) + 1);
                    break;
                case 10:
                    // 10元+1，5元-1
                    Integer fiveNums = retains.getOrDefault(5, 0);
                    if (fiveNums == 0) {
                        return false;
                    } else {
                        fiveNums--;
                        // 获取 5 元的数量，在原有的基础上+1
                        retains.put(5, fiveNums);
                        retains.put(10, retains.getOrDefault(10, 0) + 1);
                    }
                    break;
                case 20:
                    // 20元+1
                    retains.put(20, retains.getOrDefault(20, 0) + 1);

                    // 10元-1，5元-1 或者 5元-2  5元-1
                    // 优先减10元的
                    Integer tenNums = retains.getOrDefault(10, 0);
                    Integer fiveNum = retains.getOrDefault(5, 0);
                    if (fiveNum == 0) {
                        return false;
                    }
                    //至少五元减1
                    fiveNum--;
                    if (tenNums != 0) {
                        tenNums--;
                        retains.put(5, fiveNum);
                        retains.put(10, tenNums);
                    } else {
                        //10元没了
                        if (fiveNum > 1) {
                            fiveNum -= 2;
                            retains.put(5, fiveNum);
                        } else {
                            //如果小于2张五块，就不够了。
                            return false;
                        }
                    }
                    break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 5, 20, 20, 5, 5, 20, 5}));
    }
}
