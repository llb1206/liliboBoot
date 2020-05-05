package com.Thread.T4;

public class Notify {
    final static Object obj = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + "-----T1 高兴的开始了come");
                try {
                    System.out.println(System.currentTimeMillis() + "-----T1 沮丧的陷入wait");
                    obj.wait();
                } catch (InterruptedException r) {
                    r.getStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "-----T1 啦啦啦over");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + "-----T2 从T1手中拿到了权利come");
                System.out.println(System.currentTimeMillis() + "-----T2 使用notify通知T1可以开始了");
                obj.notify();
                System.out.println(System.currentTimeMillis() + "-----T2 over");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException r) {
                    r.getStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        try {
            Thread thread1 = new T1();
            Thread thread2 = new T2();
            thread1.setPriority(5);
            thread2.setPriority(1);
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}