package com.demo.course.experiment02;

import org.apache.regexp.RE;

import java.util.*;

/**
 * author: nitaotao
 * date: 2021/12/26 13:04
 * version: 1.0
 * description: todo
 */
public class Tools {
    /**
     * 检查元素是否相同，不关心元素的位置和数量
     *
     * @param A
     * @param B
     * @return
     */
    public boolean sameContents(int[] A, int[] B) {
        //先去重，再排大小，
        TreeSet<Integer> treeSetA = new TreeSet<>();
        for (int i = 0; i < A.length; i++) {
            treeSetA.add(A[i]);
        }
        TreeSet<Integer> treeSetB = new TreeSet<>();
        for (int i = 0; i < B.length; i++) {
            treeSetB.add(B[i]);
        }
        //去重后长度不一样直接错
        if (treeSetA.size() != treeSetB.size()) {
            return false;
        }
        Iterator<Integer> iteratorA = treeSetA.iterator();
        Iterator<Integer> iteratorB = treeSetB.iterator();
        //如果双方都有下一个才进入循环
        while (iteratorA.hasNext() && iteratorB.hasNext()) {
            //只要有一个不一样就错
            if (iteratorA.next() != iteratorB.next()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算A×B的结果
     *
     * @param A
     * @param B
     * @return 矩阵的乘法
     */
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        result[0][0] = A[0][0] * B[0][0] + A[0][1] * B[1][0];
        result[0][1] = A[0][0] * B[0][1] + A[0][1] * B[1][1];
        result[1][0] = A[1][0] * B[0][0] + A[1][1] * B[1][0];
        result[1][1] = A[1][0] * B[1][0] + A[1][1] * B[1][1];
//        for (int i = 0; i < A.length; i++) {
//            for (int j = 0; j < A[i].length; j++) {
//                result[i][j] = A[i][j] * B[j][i];
//            }
//        }
        return result;
    }

    /**
     * 返回孪生素数
     *
     * @param from
     * @param to
     * @return
     */
    public int[][] twinPrimes(int from, int to) {
        ArrayList list = new ArrayList();
        for (int i = from; i <= to; i++) {
            if (isSuShu(i)) {
                list.add(i);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = (int) list.get(i);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) == 2) {
                count++;
            }
        }
        int[][] twinPrimes = new int[count][2];
        int index = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i + 1] - arr[i]) == 2) {
                twinPrimes[index][0] = arr[i];
                twinPrimes[index][1] = arr[i + 1];
                index++;
            }
        }
        return twinPrimes;
    }

    /**
     * isSuShu方法：判断是否是素数
     *
     * @param num
     * @return
     */
    public boolean isSuShu(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 反转整数x，如果反转的x溢出，则返回0
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        //超出int范围
        if (Math.abs(Long.parseLong(String.valueOf(x))) > Math.abs(Long.parseLong(String.valueOf(2147483647)))) {
            return 0;
        }
        boolean isFu = false;
        if (x == 0) {
            return 0;
        }
        if (x < 0) {
            x = -x;
            isFu = true;
        }
        String[] strNum = String.valueOf(x).split("");
        String strRe = isFu ? "-" : "";
        boolean flagEndZero = true;
        for (int i = strNum.length - 1; i > -1; i--) {
            if (strNum[i].equals("0") && flagEndZero) {
                continue;
            } else {
                flagEndZero = false;
                strRe += strNum[i];
            }
        }
        if (strRe.charAt(strRe.length() - 1) == '-') {
            strRe = strRe.substring(0, strRe.length() - 2);
        }
        //如果反转后整数超过 32 位的有符号整数的范围 [−2的31,  2的31 − 1] ，就返回 0
        //MIN_VALUE的绝对值为：2147483648 > Integer.MAX_VALUE(2^31 - 1 = 2147483647)
        long result = Long.parseLong(strRe);
        if ((result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE)) {
            return 0;
        } else {
            return (int) result;
        }
    }

    /**
     * nums中只有一个元素出现一次，其他元素出现两次，返回只出现一次的元素
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        //排序，相邻差为0
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] == 0) {
                return nums[i];
            }
        }
        //不会执行到
        return 0;
    }

    /**
     * 将nums中的所有元素向左移动k步
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = k % nums.length;
            //新索引为 temp+i-nums.length
            newArr[temp + i - nums.length < 0 ? temp + i : temp + i - nums.length] = nums[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }

    /**
     * 返回nums1和nums2的公共元素
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    treeSet.add(nums1[i]);
                }
            }
        }
        int[] intersection = new int[treeSet.size()];
        Iterator<Integer> iterator = treeSet.iterator();
        int index = 0;
        while (iterator.hasNext()) {
            intersection[index] = iterator.next();
            index++;
        }
        return intersection;
    }

    /**
     * 返回nums中第k个最大元素，这些重复元素被视为不同的数字
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 升序排序
     *
     * @param nums
     */
    public void sort(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 检查非负整数n是否为4的幂
     *
     * @param n
     * @return
     */
    public boolean isPowerOfFour(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 4 != 0) {
            return false;
        }
        while (n != 1) {
            n = n / 4;
            if (n % 4 != 0 && n != 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取[from，to]中的所有友好数，返回矩阵的每一行表示一对友好数
     * 友好数又叫亲和数，它指的是这样的两个自然数，其中每个数的真因数之和等于另一个数。
     *真因数，不包括自身
     * @param from
     * @param to
     * @return
     */
    public int[][] amicableNums(int from, int to) {
        int[] nums = new int[to - from + 2];
        int sum;
        for (int i = from; i <= to; i++) {
            sum = 1;
            //获取真因数和
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            nums[i - from] = sum;
        }
        Map map = new HashMap();
        //获得 真因数和 的 数组
        for (int i = 0; i < nums.length; i++) {
            //下标+from为当前数
            // 如果nums[当前下标] 0
            // nums[当前]=sum  等于  其他数的索引下标+from，  并且， nums[其他数的索引下标]=sum 也 等于 当前下标+from
            for (int j = 0; j < nums.length; j++) {
                // j+from其他数的索引下标，可以看做是其他数
                if ((i + from == nums[j]) && (j + from == nums[i])) {
                    map.put(nums[i], nums[j]);
                }
            }
        }

        //删除重复数据 A的键和B的值不重复,并且A的键和A的值不能相同

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        ArrayList reNumlist = new ArrayList();
        while (iterator.hasNext()) {
            int key = (int) iterator.next();
            int value = (int) map.get(key);
            //不包括自身
            if (key == value) {
                reNumlist.add(key);
            }
        }
        //删除一致的数据
        for (int i = 0; i < reNumlist.size(); i++) {
            map.remove(reNumlist.get(i));
        }

        Iterator iterator2 = set.iterator();
        int[] keys = new int[set.size()];
        int[] values = new int[set.size()];
        int index = 0;
        while (iterator2.hasNext()) {
            int key = (int) iterator2.next();
            int value = (int) map.get(key);
            keys[index] = key;
            values[index] = value;
            index++;
        }
        //因为结果是成对出现的
        //只取一个
        int[][] result = new int[keys.length / 2][2];
         index = 0;
        for (int i = 0; i <keys.length ; i+=2) {
            result[index][0] = keys[i];
            result[index][1] = values[i];
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Tools tools = new Tools();
        System.out.println("========sameContents方法测试========");
        int[] arr1 = {1, 7, 9, 9, 2, 5};
        int[] arr2 = {1, 7, 9, 9, 9, 5};
        int[] arr3 = {1, 7, 2, 9, 5};
        System.out.println("arr1==arr2:" + tools.sameContents(arr1, arr2) + "  arr1==arr3:" + tools.sameContents(arr1, arr3) + "  arr2==arr3:" + tools.sameContents(arr2, arr3));
        System.out.println("========multiply方法测试========");
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{1, 0}, {0, 1}};
        int[][] multiply = tools.multiply(A, B);
        for (int i = 0; i < multiply.length; i++) {
            for (int j = 0; j < multiply[i].length; j++) {
                System.out.print(multiply[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========twinPrimes方法测试========");
        int[][] twinPrimesArr = tools.twinPrimes(0, 100);
        for (int i = 0; i < twinPrimesArr.length; i++) {
            for (int j = 0; j < twinPrimesArr[i].length; j++) {
                System.out.print(twinPrimesArr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========twinPrimes方法测试========");
        System.out.println("原数字:" + 900 + "  反转后:" + tools.reverse(900));
        System.out.println("========singleNumber方法测试========");
        int[] nums = {1, 2, 9, 5, 7, 6, 2};
        System.out.println(tools.singleNumber(nums));
        System.out.println("========reverse方法测试========");
        int[] reverseArr = {1, 2, 9, 5, 7, 6, 2};
        tools.rotate(reverseArr, 3);
        for (int i = 0; i < reverseArr.length; i++) {
            System.out.print(reverseArr[i] + " ");
        }
        System.out.println();
        System.out.println("========intersection方法测试========");
        int[] intersectionA = {1, 58, 9, 3, 47, 4, 5, 7, 8};
        int[] intersectionB = {9, 3, 56, 42, 7};
        int[] intersection = tools.intersection(intersectionA, intersectionB);
        for (int i = 0; i < intersection.length; i++) {
            System.out.print(intersection[i] + " ");
        }
        System.out.println();
        System.out.println("========findKthLargest方法测试========");
        int[] findKthLargest = {1, 58, 9, 3, 47, 4, 5, 7, 8};
        System.out.println(tools.findKthLargest(findKthLargest, 3));
        System.out.println("========sort方法测试========");
        int[] sortArr = {1, 58, 9, 3, 47, 4, 5, 7, 8};
        tools.sort(sortArr);
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + " ");
        }
        System.out.println();
        System.out.println("isPowerOfFour方法测试========");
        System.out.println("32是4的幂次：" + tools.isPowerOfFour(32));
        System.out.println("16是4的幂次：" + tools.isPowerOfFour(16));
        System.out.println("========amicableNums方法测试========");
        int[][] amicableNumsArr = tools.amicableNums(1, 2000);
        for (int i = 0; i < amicableNumsArr.length; i++) {
            for (int j = 0; j < amicableNumsArr[i].length; j++) {
                System.out.print(amicableNumsArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
