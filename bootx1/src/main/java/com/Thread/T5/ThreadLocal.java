package com.Thread.T5;

public class ThreadLocal {
    /**
     * 两者获得ThreadLocal初始值，但是线程不能互相修改ThreadLocal变量，始终是副本级别
     * 用途之一可以作为连接，初始化后可以保证不被其他线程修改
     */
    public final static java.lang.ThreadLocal<String> s = new java.lang.ThreadLocal<String>();
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                s.set("123");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(s.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.set("456");
                System.out.println(s.get());
            }
        }).start();
    }
}
