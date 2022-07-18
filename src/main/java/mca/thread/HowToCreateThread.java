package mca.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @ClassName HowToCreateThread
 * @Descriotion TODO
 * @Author nitaotao
 * @Date 2022/7/18 9:04
 * @Version 1.0
 * 创建多线程的五种方式
 **/
public class HowToCreateThread {
    /**
     * 方式 1 继承Thread类，重写run方法
     */
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    /**
     * 方式 2 实现Runnable接口，重写run方法
     */
    static class MyRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Hello MyRun!");
        }
    }

    /**
     * 方式 3 实现Callable接口，重新call方法
     */
    static class MyCall implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Hello MyCall");
            return "success";
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        new Thread(new MyRun()).start();
        Thread t = new Thread(new FutureTask<String>(new MyCall()));
        t.start();

        /**
         * 方式 4 使用Lambda表达式
         */
        new Thread(() ->{
            System.out.println("Hello Lambda");
        }).start();

        /**
         * 方式 5 使用线程池
         */
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(()->{
            System.out.println("Hello ThreadPool");
        });
        service.shutdown();
    }
}
