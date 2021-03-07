package com.Thread.T7;

/**
 https://blog.csdn.net/XIANZHIXIANZHIXIAN/article/details/86091957
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadB b = new ThreadB();
            ThreadA a = new ThreadA(b);
            a.start();
            b.start();
            b.join(2000);
            System.out.println("main end "+System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}