package com.Thread.T6;

import lombok.SneakyThrows;

/**
 当 JVM 中不存在任何一个正在运行的非守护线程时，则 JVM 进程即会退出。
 https://blog.csdn.net/weiwosuoai/article/details/89387280
 */
public class DaemonThread {

    public static void main(String[] args){
        Thread t = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(10000);
                System.out.println("t 线程执行完毕............dddddddddddddddddddddddddddddddddddddddddddddd.");
            }
        });
        Thread guardT = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("守护线程正在执行...");
                }
            }
        });
        guardT.setDaemon(true);
        guardT.start();
        t.start();
    }
}