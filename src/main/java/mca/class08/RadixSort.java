package mca.class08;

/**
 * @ClassName RadixSort
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/3 9:31
 * @Version 1.0
 **/
public class RadixSort {

    /**
     * 返回当前序列最大是几位数
     *
     * @param arr
     * @return
     */
    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    /**
     * arr[L...R]排序，最大值的十进制位数 digit
     *
     * @param arr
     * @param L
     * @param R
     * @param digit digit位的十进制数
     */
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        //arr中的数的下标
        int i = 0;
        //当前数多少位
        int j = 0;
        //有多少个数就准备多少个空间
        //默认全是>=0，当然，如果有负数也好办，
        //找到最小负数，所有数 + 最小负数的绝对值，让最小值归零，排完序再减去对应值
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) {
            //有多少位就进出多少次
            //10个空间
            //count[0] 当前位(d位)  是0的数有多少个
            //count[1] 当前位(d位)  是[0,1]的数有多少个
            //count[2] 当前位(d位)  是[0,2]的数有多少个
            //count[i] 当前位(d位)  是[0,i]的数有多少个

            // count[0,9]
            //每个数个位是几，那个位置就数量+1
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }

            for (i = R; i >= L; i--) {
                //从右往左
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            //复制回原数组
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }

        }


    }

    //取最后一位数

    /**
     * 取x数倒数第d位
     *
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x, int d) {
        //挪移多少位
        System.out.println(d);
        int a = (int)(Math.pow(10, d - 1));
        System.out.println(a);
        //取到多少位
        int b = x / a;
        return b % 10;
    }

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 5, 25, 354, 3155, 44, 3, 7};
        radixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
