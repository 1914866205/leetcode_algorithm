package mca;

import java.util.Scanner;

/**
 * @ClassName Main2
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/9/17 16:03
 * @Version 1.0
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //刷漆次数
        int n = sc.nextInt();
        // p漆的次数
        int p = sc.nextInt();
        // q漆的次数
        int q = sc.nextInt();
        //思路，使用hashmap
        //矩阵第一行，所有左边界
        //矩阵第二行，所有右边界
        //矩阵第三行，当前标记颜色
        //改成五行三列
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][2]=sc.nextInt();
        }
        //当前矩阵 五行三列，行为 左边界、右边界、类型
        //列为每次刷漆数目
        //从1开始计算
        Item[] arrItem = new Item[10];
        for (int i = 0; i < arr.length; i++) {
            //每一次刷漆
            for (int j = arr[i][0]; j <= arr[i][1]; j++) {
                //如果第j位无元素
                if (arrItem[j] == null) {
                    arrItem[j] = new Item();
                    if (arr[i][2] == 1) {
                        arrItem[j].p = 1;
                    } else {
                        arrItem[j].q = 1;
                    }
                }else {
                    if (arr[i][2] == 1) {
                        arrItem[j].p += 1;
                    } else {
                        arrItem[j].q += 1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 1; i < arrItem.length; i++) {
            if (arrItem[i] == null) {
                continue;
            }
            if (arrItem[i].p >= p && arrItem[i].q >= q) {
                count++;
            }
        }
        System.out.print(count);
    }

    static class Item{
        int p = 0;
        int q = 0;
    }
}
