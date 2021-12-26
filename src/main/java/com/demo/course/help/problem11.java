package com.demo.course.help;

/**
 * author: nitaotao
 * date: 2021/12/26 16:54
 * version: 1.0
 * description: todo
 */
    import java.util.Scanner;
public class problem11 {

        /**
         * add方法：判断是否有前导0，如果有就跳过这个0
         *
         //   * @param A[],B[] 传入的数组长度和一个数组
         */
        public void add(int l1,int l2,int[] A, int[] B) {
            int i;
            int max=Math.max(l1,l2);
            int[]sum=new int[max+1];  //下标有进位
            //对应位相加
            int k = 0;  // k表示进位
            for (i = 0; i < max; i++) {
                sum[i] = (A[i] + B[i] + k) % 10;  //和≥10时，保留个位
                k = (A[i] + B[i] + k) / 10;  //取出十位上的数，用k表示进位
            }
            sum[i] = k;  //把进位k存入最后一位

            boolean isZero = true;
            for (i = max; i >= 0; i--) {
                if (sum[i] == 0 && isZero)
                    continue;  //有前导0则跳过
                else {
                    isZero = false;
                    System.out.print(sum[i]);
                }
            }
        }

        /* 以下为main方法 */
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            String str1 = input.nextLine();
            String str2 = input.nextLine();
            int max,i;
            if(str1.length()>=str2.length())
                max=str1.length();
            else max=str2.length();  //找出字符串长度长的那个
            int[]A=new int[max];
            int[]B=new int[max];
            int l1,l2;
            l1=str1.length();
            l2=str2.length();
            //把字符串转化为数组,并逆序存放
            for(i=0;i<l1;i++)
                A[i]=str1.charAt(l1-1-i)-'0';
            for(i=0;i<l2;i++)
                B[i]=str2.charAt(l2-1-i)-'0';

            problem11 main = new problem11();  //main负责调用方法

            main.add(l1,l2,A,B);
        }
}
