package com.Thread.T6;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 循环屏障  集中处理 让同一批线程处在处理同步位置  先处理完的等待未处理完的，然后一起再开始（规定数量）
 */
public class TestCyclicBarrier {

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"继续处理其他任务...");
        }
    }

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0; i < 9; i++)     //假如启动的线程大于栅栏数目，因为栅栏是固定的，
                                       // 但是可以循环使用，如果不是倍数，是会被阻塞的
            new Writer(barrier).start();
    }
}