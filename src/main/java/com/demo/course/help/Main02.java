package com.demo.course.help;

/**
 * author: nitaotao
 * date: 2021/12/28 10:54
 * version: 1.0
 * description: todo
 */
import java.util.Scanner;

public class Main02 {
    /**
     * add方法：判断是否有前导0，如果有就跳过这个0
     *
     //     * @param m2传入的数组长度和数组
     */
    public int find(int[]data, int value) {
        //如果data数组只有一个数值，据返回这个值
        if (data.length == 1) {
            return data[0];
        }
        int left = 0;  // 起始位置
        int right = data.length - 1;  // 结束位置
        //二分查找法查找有无与查找数相等的数
        int mid, ans = -1;
        while (left <= right) {
            mid = (left + right) / 2;  // 计算中间位置下标
            if (data[mid] == value) {  // 如果刚好中间值与要查找的值相等就返回该数
                ans = mid;  // 记住下标
                break;
            }
            // 待查找数值比中间数值小，即待查找数值在数轴中间位置左边
            else if (data[mid] > value) {
                right = mid - 1;
            }
            // 待查找数值比中间数值大，即待查找数值在数轴中间位置右边
            else {
                left = mid + 1;
            }
        }
        if(ans!=-1){
            return data[ans];
        }
        // 遍历完还没找到与要查找的数相等的值
        else{
            if(right==-1) ans=left;  // 要查找的值<最左边的数，返回最左边的数
            else if(left>=data.length-1) ans=right;  // 要查找的值>最右边的数，返回最右边的值
            else {
                // 要查询的数值在[left,right]中
                // 返回距离最小的数
                if(Math.abs(data[left]-value)<Math.abs(data[right]-value))
                    ans = left;
                else ans = right;
            }
            return data[ans];
        }
    }


    /* 以下为main方法 */
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();  // 输入非降序序列的长度
        int[]data={0,1,2,2,3,6,7,8,50,51,55,90,91,92,94,95,100};  // 给定值数组
        int[]select={0,1,2,3,4,5,8,9,47,49,50,52,53,89,90,91,93,97,105};  // 需要询问的元素
        int i,j=0,l;
//        for(i=0;i<n;i++)  // 循环输入n1个整数
//            data[i] = input.nextInt();
//        int m = input.nextInt();  // 输入要查询的数字个数
//        for(i=0;i<m;i++)  // 输入需要询问的值
//            select[i] = input.nextInt();
        l=select.length;  // select数组的长度

        Main02 main= new Main02();
        for(i=0;i<l;i++)
            System.out.println("被查找数："+select[i]+"   查找到的值："+main.find(data,select[i]));
    }
}