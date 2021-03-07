package com.Thread.T8;

import java.util.concurrent.atomic.AtomicInteger;


public class TestAtomic {
//Atomic  额掏美克
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static int num=1;
    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable() {


            @Override
            public void run() {
                for (int i=0;i<1000;i++) {
                    //atomicInteger.incrementAndGet();
                    num++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++) {
                    //atomicInteger.incrementAndGet();
                    num++;
                }
            }
        });
        t1.start();
       // t2.start();
        t1.join();//主线程等待t1执行完  join
        t2.join();//主线程等待t2执行完  join
        System.out.println("最终结果：" + atomicInteger);
    }
}