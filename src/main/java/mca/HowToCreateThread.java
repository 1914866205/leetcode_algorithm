package mca;

import java.util.concurrent.*;

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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new MyThread().start();

        new Thread(new MyRun()).start();

        FutureTask<String> task = new FutureTask<String>(new MyCall());
        Thread t = new Thread(task);
        t.start();
        System.out.println(task.get());



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


        //实现Callable最方便的方式是使用线程池调用    异步操作
        // Future 将来的    将来有可能拿到
        Future<String> f = service.submit(new MyCall());
        //这是一个阻塞类型的方法
        //执行完 call() 装好这个Furture 拿到这个值为止，才能继续往下执行
        String s = f.get();
        service.shutdown();
    }
}
