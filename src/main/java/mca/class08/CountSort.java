package mca.class08;

/**
 * @ClassName CountSort
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/2 17:50
 * @Version 1.0
 **/
public class CountSort {
    // 计数排序
    public static void countSort(int[]arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //找到数组中元素的最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        // arr 中的数字 >=0
        int[] bucket = new int[max + 1];
        //把数放到桶中的对应位置
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        //直接遍历桶
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                //当前位置本数字次数 减 1
                bucket[j]--;
                // 把当前位置排到原始数组中
                arr[i] = j;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 5, 25, 354, 3155, 44, 3, 7};
        countSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
