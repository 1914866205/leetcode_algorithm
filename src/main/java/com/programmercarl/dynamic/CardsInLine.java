package com.programmercarl.dynamic;

/**
 * @ClassName CardsInLine
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/28 22:53
 * @Version 1.0
 **/
public class CardsInLine {
    public int cardsInLine(int[] arr) {
        //如果无值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //返回赢家的分数
        return Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
    }

    //先手
    private int first(int[] arr, int left, int right) {
        //如果只剩最后一张牌了，则先手拿走，后手无
        if (left == right) {
            return arr[left];
        }
        //先手从牌中取最大值  50 100 20 10
        //如果先手第一次拿50，第二次就只能拿10  60
        int leftCard = arr[left] + second(arr, left + 1, right);
        //如果先手第一次拿10，第二次就只能拿100    110
        int rightCard = arr[right] + second(arr, left, right - 1);
        //返回先手所能选择的最大值
        return Math.max(leftCard, rightCard);
    }
    //后手
    public int second(int[] arr, int left, int right) {
        //后手无牌
        if (left == right) {
            return 0;
        }
        //后手不用加 arr[left] arr[right] 他没得选择
        //此时后手变为了先手
        int leftCard = first(arr, left + 1, right);
        int rightCard = first(arr, left, right - 1);
        //这个返回值，是给上一个先手用的，因为当前后手会给你留一个小的
        return Math.min(leftCard, rightCard);
    }

    public static void main(String[] args) {
        System.out.println(new CardsInLine().cardsInLine(new int[]{5,7,4,5,8,1,6,0,3,4,6,1,7}));
    }
}
