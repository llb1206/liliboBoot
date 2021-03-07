package com.Thread.T1;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class piaotest extends Thread {

    static ExecutorService pool = Executors.newFixedThreadPool(5);

    int a = 100;
    ReentrantLock r = new ReentrantLock();
    @SneakyThrows
    @Override
    public void run() {
        sale();
    }

    void sale() throws InterruptedException {
        while (a > 0) {
            r.lock();
            if( a == 0){
                System.out.printf("票已经售光");
                break;
            }
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + "当前正在出售第" + (100 - a + 1) + "张票");
            a--;
            r.unlock();
        }
    }


    public static void main(String[] args) {

        piaotest p = new piaotest();
        Thread[] t = new Thread[10];
        for (int i = 0; i < 10; i++) {
            t[i] = new Thread(p,"线程"+i);
            t[i].start();
        }
    }
}
