package com.Thread.T1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class PersonOne implements Runnable {

    private int count = 100;
    ReentrantLock lock = new ReentrantLock();
    static ExecutorService pool = Executors.newFixedThreadPool(5);

    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            sale();
            lock.unlock();
        }
    }

    public void sale() {
        lock.lock();
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "正在出售第" + (100 - count + 1) + "张票");
            count--;
        }
        lock.unlock();
    }
}

public class CatchTicket {
    public static void main(String[] args) {

        PersonOne p = new PersonOne();
        for (int i = 0; i < 6; i++) {
            PersonOne.pool.submit(p);
        }

        PersonOne.pool.shutdown();

//        Thread[] t = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            t[i] = new Thread(p, "窗口" + i);
//            t[i].start();
//        }
    }
}