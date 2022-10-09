package mca.class11;

/**
 * @ClassName PaperFolding
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/10/9 23:18
 * @Version 1.0
 * 微软折纸面试题
 **/
public class PaperFolding {
    public static void printAllFolds(int n) {
        process(1, n, true);
        System.out.println();
    }

    /**
     * @param i      当前第i次折纸
     * @param n      一共折n次
     * @param isLeft 是不是左子树
     *               折纸：头结点为 凹
     *               左子节点 凹，右子节点凸
     */
    private static void process(int i, int n, boolean isLeft) {
        if (i > n) {
            return;
        }
        process(i + 1, n, true);
        if (isLeft) {
            System.out.print("凹");
        } else {
            System.out.print("凸");
        }
        process(i + 1, n, false);
    }

    public static void main(String[] args) {
        printAllFolds(1);
        printAllFolds(2);
        printAllFolds(3);
    }
}

