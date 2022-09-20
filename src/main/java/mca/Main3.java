package mca;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName Main3
 * @Descriotion 小米一面第一题
 * @Author nitaotao
 * @Date 2022/9/20 18:45
 * @Version 1.0
 **/
public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        ArrayList list = new ArrayList();
        new Thread(()->{
            while (true) {
                int a = sc.nextInt();
                list.add(a);
            }
        }).start();
        Thread.sleep(20000);
        int n = 0;
        int t = list.size();
        int[][] timeArr = new int[list.size() / 2][2];
        while (n < t) {
            timeArr[n/2][0] = (int) list.get(n);
            timeArr[n/2][1] = (int) list.get(n + 1);
            n += 2;
        }
        System.out.println(getTime(timeArr));
    }

    public static int getTime(int[][] timeArr) {
        int[] time = new int[24];
        for (int i = 0; i < timeArr.length; i++) {
            for (int j = timeArr[i][0]; j < timeArr[i][1]; j++) {
                time[j] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < time.length; i++) {
            res += time[i];
        }
        return res;
    }

}
