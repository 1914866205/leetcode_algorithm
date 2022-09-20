package mca;

import java.util.Scanner;

/**
 * @ClassName Main5
 * @Descriotion 百度一面第一题
 * @Author nitaotao
 * @Date 2022/9/20 20:24
 * @Version 1.0
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //点赞量
        int star = 0;
        //回复量
        int rec = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            switch (arr[i]) {
                case 1:
                    //水贴王
                    rec++;
                    break;
                case 2:
                    star++;
                    break;
                case 3:
                    if (rec == star) {
                        rec++;
                        star++;
                    } else if (rec > star) {
                        rec++;
                    } else {
                        star++;
                    }
                    break;
                case 4:
                    break;
            }
            System.out.print(rec);
            System.out.print(star);

        }
    }
}
