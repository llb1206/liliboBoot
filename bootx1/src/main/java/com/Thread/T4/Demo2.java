package com.Thread.T4;

public class Demo2 {
    private static volatile int i = 1;

    public static void main(String[] args) throws Exception {
        final Object obj = new Object();

        Runnable runnable = () -> {
            synchronized (obj) {
                for (; i < 10; ) {
                    try {
                         System.out.println(Thread.currentThread().getName() + " " + (i++));
                            obj.notify();
                            obj.wait();//不能写前面 要不都堵住了
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    for (; i < 10; ) {
                        try {
                            System.out.println(Thread.currentThread().getName() + " " + (i++));
                            obj.notify();
                            obj.wait();//不能写前面 要不都堵住了
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };


        Thread t1 = new Thread(runnable, "AAAAAAA--");
        Thread t2 = new Thread(runnable2, "BBBBBBB--");
        t2.start();
        t1.start();
    }
}