package mca;


import java.util.Scanner;

/**
 * @ClassName Main
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/19 14:39
 * @Version 1.0
 **/
public class Main {

    /**
     * ?12?0?9??
     * 样例输出
     * 212101902
     * 第一位不为0
     * 相邻不重复
     * 可被3整除
     *
     * @param args
     */
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String numStr = sc.nextLine();
        String numStr = "?12?0?9??";
        char[] chars = numStr.toCharArray();
        //位数
        int i = (int) Math.pow(10, chars.length - 1);
        while (i % 3 != 0) {
            i -= 1;
        }
        for (; i < (int) Math.pow(10, chars.length); i += 3) {
            int temp = i;
            int j = chars.length - 1;
            for (; j >= 0; j--) {
                if (!(temp % 10 == chars[j] - '0' || chars[j] == '?')) {
                    //相等，比下一位，或者不相等，却是?
                    break;
                }
                temp /= 10;
            }
            if (j == -1) {
                String s = String.valueOf(i);
                final char[] chars1 = s.toCharArray();
                int k = 1;
                for (; k < chars1.length; k++) {
                    if (chars1[k] == chars1[k - 1]) {
                        break;
                    }
                }
                if (k == chars1.length) {
                    System.out.print(i);
                    break;
                }
            }
        }

    }
}
