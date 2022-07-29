package com.programmercarl.dynamic;

/**
 * @ClassName CardsInLine
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/28 22:53
 * @Version 1.0
 * https://blog.csdn.net/niTaoTaoa/article/details/126051406
 * 暴力递归到动态规划 02 （绝顶聪明的人的纸牌游戏）
 **/
public class CardsInLine {
    public int cardsInLine(int[] arr) {
        //如果无值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        //返回赢家的分数
        System.out.println();
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


    public int cardsInLine2(int[] arr) {
        //如果无值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        //先手数组
        int[][] firstArr = new int[n][n];
        //后手数组
        int[][] secondArr = new int[n][n];
        //没填值时初始化为-1
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                firstArr[i][j] = -1;
                secondArr[i][j] = -1;
            }
        }
        //返回赢家的分数
        return Math.max(first2(arr, 0, arr.length - 1, firstArr, secondArr), second2(arr, 0, arr.length - 1, firstArr, secondArr));
    }


    private int first2(int[] arr, int left, int right, int[][] firstArr, int[][] secondArr) {
        //如果这个位置的元素已经计算出来，直接返回当前元素
        if (firstArr[left][right] != -1) {
            return firstArr[left][right];
        }
        //如果只有一个牌
        if (left == right) {
            firstArr[left][right] = arr[left];
            return firstArr[left][right];
        }
        //否则计算
        int getLeft = arr[left] + second2(arr, left + 1, right, firstArr, secondArr);
        int getRight = arr[right] + second2(arr, left, right - 1, firstArr, secondArr);
        firstArr[left][right] = Math.max(getLeft, getRight);
        return firstArr[left][right];
    }

    private int second2(int[] arr, int left, int right, int[][] firstArr, int[][] secondArr) {
        if (secondArr[left][right] != -1) {
            return secondArr[left][right];
        }
        //如果只有一个牌
        if (left == right) {
            secondArr[left][right] = 0;
            return secondArr[left][right];
        }
        //后手此时作为先手，取值
        int getLeft =first2(arr, left+1, right, firstArr, secondArr);
        int getRight = first2(arr, left, right-1, firstArr, secondArr);
        secondArr[left][right] = Math.min(getLeft, getRight);
        return secondArr[left][right];
    }


    public int cardsInLine3(int[] arr) {
        //如果无值
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int n = arr.length;
        //先手数组
        int[][] firstArr = new int[n][n];
        //后手数组
        int[][] secondArr = new int[n][n];
        //初始化先手数组对角线元素为最后一张牌时的选择，后手数组为0
        for (int i = 0; i <n ; i++) {
            firstArr[i][i] = arr[i];
        }
        // L为横，R为纵
        //两个二维数组只用右上角，因为 L<=R横成立
        // firstArr[0][0]已经赋值过了
        for (int i = 1; i < n; i++) {
            int left = 0;
            int right = i;
            while (right < n) {
                firstArr[left][right] = Math.max(arr[left] + secondArr[left + 1][right], arr[right] + secondArr[left][right - 1]);
                secondArr[left][right] = Math.min(firstArr[left + 1][right], firstArr[left][right - 1]);
                left++;
                right++;
            }
        }
        //返回赢家的分数
        return Math.max(firstArr[0][n-1],secondArr[0][n-1]);
    }

    public static void main(String[] args) {
        System.out.println(new CardsInLine().cardsInLine(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));
        System.out.println(new CardsInLine().cardsInLine2(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));
        System.out.println(new CardsInLine().cardsInLine3(new int[]{5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7}));
    }
}
