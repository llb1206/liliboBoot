package com.Thread.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicCount = new AtomicInteger(0);
    private int i = 0;

    /** cas cafecount **/
    private void safeCount() {
        for (; ;) {
            int i = atomicCount.get();//获取旧值
            boolean suc = atomicCount.compareAndSet(i, ++i);
            if (suc) {
                break;                //success
            }
        }
    }

    public static void main(String[] args) {
        Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(500);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread t = new Thread(() -> {       //....
                for (int i = 0; i < 10000; i++) {
                    cas.safeCount();
                }
            });
            ts.add(t);
        }
        for (Thread t : ts) {
            t.start();
        }
        for (Thread t : ts) {//等待完成，相当于计数器作用？？？
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i+"--start");
        System.out.println(cas.atomicCount.get()+"--end");
        System.out.println(System.currentTimeMillis() - start+"--ms");
    }
}