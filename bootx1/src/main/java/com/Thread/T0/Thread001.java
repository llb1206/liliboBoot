package com.Thread.T0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Thread001 implements Runnable {
    int p = 1000;

    @Override
    public void run() {
        try {
            ss();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ss() throws Exception {

        while (p > 0) {
            synchronized (this) {
                Thread.sleep(10);
                if (p == 0) {
                    System.out.println("票已经售光");
                    break;
                }
                System.out.println("当前余票" + p + "********" + Thread.currentThread().getName());
                --p;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        Thread001 a = new Thread001();
        for (int i = 0; i <5 ; i++) {
            pool.submit(a);
       }
        pool.shutdown();

//        Thread a1 = new Thread(a);
//        Thread a2 = new Thread(a);
//        Thread a3 = new Thread(a);
//        a1.start();
//        a2.start();
//        a3.start();
    }
}
