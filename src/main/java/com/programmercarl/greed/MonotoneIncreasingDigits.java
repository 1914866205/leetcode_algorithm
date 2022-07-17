package com.programmercarl.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MonotoneIncreasingDigits
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/17 14:49
 * @Version 1.0
 * 738. 单调递增的数字
 * https://leetcode.cn/problems/monotone-increasing-digits/
 **/
public class MonotoneIncreasingDigits {
    /**
     * 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。
     * 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。
     *
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            int temp = n;
            while (temp / 10 != 0) {
                //temp还不是个位
                list.add(temp % 10);
                temp = temp / 10;
            }
            //最后一位
            list.add(temp % 10);
            //只有一位数，直接返回
            if (list.size() == 1) {
                return n;
            }
            // 个位、十位、百位
            int preNum = list.get(0);
            boolean need = true;
            for (int i = 1; i < list.size(); i++) {
                //倒过来就是单调递减 十位<=个位   则为 个位<十位
                if (preNum < list.get(i)) {
                    need = false;
                    break;
                }
                //更新前一个数字
                preNum = list.get(i);
            }
            if (need) {
                return n;
            }
            //如果到最后
            n--;
            list.clear();
        }
    }

    public int monotoneIncreasingDigits2(int n) {

        while (true) {
            if (n / 10 == 0) {
                //n为个位数
                return n;
            }
            int temp = n;
            char[] chars = String.valueOf(temp).toCharArray();
            boolean flag = true;
            for (int i = 0; i < chars.length - 1; i++) {
                flag = flag && chars[i] <= chars[i + 1];
                if (!flag) {
                    break;
                }
            }
            if (flag) {
                return n;
            }
            n--;
        }
    }

    public int monotoneIncreasingDigits3(int n) {
        while (true) {
            // n 为个位数
            if (n / 10 == 0) {
                return n;
            }
            int temp = n;
            int preNum;
            boolean need = true;
            while (temp / 10 != 0) {
                //temp还不是个位
                preNum = temp % 10;
                temp = temp / 10;
                //倒过来就是单调递减 十位<=个位   则为 个位<十位
                if (preNum < temp % 10) {
                    need = false;
                    break;
                }
            }
            if (need) {
                return n;
            }
            //如果到最后
            //个位数减到之前比这个数大，至少要减9
//            10 -1  09 08 07
//            52  49 48 47 46 45 44
//            82  79 78 77
            if (n > 10) {
                //个位置为9，十位减一
                n = n - 10 - n % 10 + 9;
            } else {
                n--;
            }
        }
    }

    public int monotoneIncreasingDigits4(int n) {
        //把数字转成字符数组
        char[] chars = String.valueOf(n).toCharArray();
        //开始变9的起始位置
        int startToNine = chars.length;
        //从十位开始往高位走
        for (int i = chars.length - 2; i >= 0; i--) {
            //如果是非单调增 <= ，即 >
            if (chars[i] > chars[i + 1]) {
                //向高位借位
                chars[i]--;
                //重置 开始变9的位置
                startToNine = i + 1;
            }
        }
        //从这一位起全置为9
        for (int i = startToNine; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits4(705281510));
    }
}
