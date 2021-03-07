package com.Thread.T5;

import lombok.SneakyThrows;

public class TestVolatile implements Runnable{
    //boolean  status = false;
    volatile  boolean  status = false;

    /**
     *  是“可能”  不是一定，并不保证一定会可见的
     * 上面这个例子，在多线程环境里，假设线程A执行changeStatus()方法后
     * 线程B运行run()方法，可以保证输出"running....."吗？
     */
    public void changeStatus(){
        System.out.println("123");
        status = true;
    }

    /**
     * 若状态为true，则running。
     */
    @SneakyThrows
    @Override
    public void run(){

        if(status){
            System.out.println("runing.........");
        }else{
            System.out.println("error");
        }
    }


    public static void main(String[] args) {
        TestVolatile Volatile =  new TestVolatile();
        new Thread(Volatile).start();
        Volatile.changeStatus();
    }
}