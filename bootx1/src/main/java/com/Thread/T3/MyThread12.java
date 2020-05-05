package com.Thread.T3;

public class MyThread12 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        System.out.println("线程开始执行时间：" + beginTime);
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();    //调用yield()方法，暂时不用
            count = count + (i + 1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("线程结束执行时间：" + endTime);
        System.out.println("本次执行用时：" + (endTime - beginTime) + "毫秒！");
    }

    //yieId() 方法的作用是放弃当前的 CPU 资源，将它让给其他的任务去占用 CPU 执行时间。
    // 但放弃的时间不确定，有可能刚刚放弃，马上又获得 CPU 时间片。
    public static void main(String[] args) {
        MyThread12 thread = new MyThread12();    //创建MyThread12线程实例
        thread.start();    //启动线程
    }
}