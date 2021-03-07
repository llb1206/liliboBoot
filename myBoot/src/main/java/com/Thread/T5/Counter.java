package com.Thread.T5;

import java.util.concurrent.CountDownLatch;

/**
 * https://www.cnblogs.com/chengxiao/p/6528109.html
 */
public class Counter {
    public static volatile int num = 0;
    //使用CountDownLatch来等待计算线程执行完
    static CountDownLatch countDownLatch = new CountDownLatch(30);
    public static void main(String []args) throws InterruptedException {
        //开启30个线程进行累加操作
        for(int i=0;i<30;i++){
            new Thread(() -> {
                for(int j=0;j<10000;j++){
                    num++;//自加操作
                }
                countDownLatch.countDown();
            }).start();
        }
        //等待计算线程执行完
        countDownLatch.await();
        System.out.println(num+"countDownLatch 执行完了");
    }
}