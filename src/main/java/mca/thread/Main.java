package mca.thread;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.Executor;

/**
 * @ClassName Main
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/19 14:39
 * @Version 1.0
 **/
public class Main {

    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
