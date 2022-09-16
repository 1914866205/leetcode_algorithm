package mca;

/**
 * @ClassName Hello
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/8/9 9:27
 * @Version 1.0
 **/
public class Hello {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(11111);
            }
        }).start();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(22222);
            }

        }).start();
        new Thread(() -> {
            synchronized (o) {
                while (true) {

                }
            }

        }).start();
    }
}
