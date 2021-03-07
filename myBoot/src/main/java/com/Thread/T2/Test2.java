package com.Thread.T2;

import java.util.concurrent.*;

public class Test2 {
    //采用newFixedThreadPool()方法创建线程池，设置线程池中有2个线程
    //static ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    //或者采用下述方式生成线程连接池
    static ExecutorService pool = Executors.newFixedThreadPool(5);
    BlockingQueue queue = new LinkedBlockingQueue();
    ThreadPoolExecutor executor =
            new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS, queue);


    public static void main(String[] args) {
        Callable C = new MyCall();
        Future<String> s1 = pool.submit(C);
        Future<String> s2 = pool.submit(C);
        Future<String> s3 = pool.submit(C);
        Future<String> s4 = pool.submit(C);
        try {
            System.out.println(s1.get());
            System.out.println(s2.get());
            System.out.println(s3.get());
            System.out.println(s4.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //切记：线程池不是线程执行结束就终止，而是手动终止
        pool.shutdown();
    }

    public static void main2(String[] args) {
        pool.submit(new MyRun("张三"));
        pool.submit(new MyRun("李四"));
        pool.submit(new MyRun("王五"));
        pool.submit(new MyRun("赵六"));
        //切记：线程池不是线程执行结束就终止，而是手动终止
        pool.shutdown();
    }

    public static void main1(String[] args) {
        pool.submit(new MyThread("张三"));
        pool.submit(new MyThread("李四"));
        pool.submit(new MyThread("王五"));
        pool.submit(new MyThread("赵六"));
        //切记：线程池不是线程执行结束就终止，而是手动终止
        pool.shutdown();
    }
}

//通过继承Thread创建线程
class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    int num = 10;

    @Override
    public void run() {
        while (num >= 0) {
            try {
                Thread.sleep(100);//线程休眠
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在数：" + num);
            num--;
        }
    }
}

//通过实现Runnable接口创建线程
class MyRun implements Runnable {
    public MyRun(String name) {
        Thread.currentThread().setName(name);
    }

    int num = 10;

    @Override
    public void run() {
        while (num >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在数：" + num);
            num--;
        }
    }
}

//通过实现Callable接口创建线程
class MyCall implements Callable<String> {
    int num = 10;

    @Override
    public String call() throws Exception {
        while (num >= 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "正在数：" + num);
            num--;
        }
        return Thread.currentThread().getName() + "顺利执行";
    }
}