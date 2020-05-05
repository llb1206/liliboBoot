package com.Thread.T3;

public class MyThread08 extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());//查看线程状态
    }

    public static void main(String[] args) {
        MyThread08 mythread = new MyThread08();    //创建一个MyThread08线程实例
        System.out.println("begin==" + mythread.isAlive());    //输出线程状态
        mythread.start();    //启动线程
        System.out.println("end==" + mythread.isAlive());    //输出线程状态
///****************
        System.out.println("当前线程名称："+mythread.getName());
        System.out.println("当前线程标识："+mythread.getId());
    }
}