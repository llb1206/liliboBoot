package com.Thread.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /**
     * 定义一个线程安全的Integer并设定初始值为0
     */
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100000; j++) {
            Thread addThread = new Thread(() -> {//使用拉姆达  可以不用写 run
                // 原子的增加1
                atomicInteger.incrementAndGet();
                i++;
            });
            addThread.start();
        }
        Thread.sleep(2000);
        System.out.println(atomicInteger.get());
        System.out.println(i);
    }
}