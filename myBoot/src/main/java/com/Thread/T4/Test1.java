package com.Thread.T4;

public class Test1 {
    static final Object object = new Object(); //共享对象，用来实现对象锁

    public static void main(String[] args) {
		Thread t1 =  new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 18; i++) {
                    synchronized (object) {
                        if (i % 2 == 0) {
                            System.out.print(i);
                            object.notifyAll();//唤醒线程2
                            try {
                                //System.out.println("------线程1 开始等待");
                                object.wait();  //当前线程释放对象锁
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            System.out.print(i);
                        }
                    }
                }
            }
        });
		t1.setPriority(10);
		t1.start();
		Thread t2 =   new Thread(new Runnable() {
            char[] c = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
            public void run() {
                for (int i = 0; i <= 9; i++) {
                    //获取对象锁后，执行以下内容
                    synchronized (object) {
                        System.out.print("--"+c[i]+"--");
                        //System.out.println("线程1开始执行");
                        object.notify();  //唤醒线程1
                        try {
                            //System.out.println("---------线程2 开始等待");
                            object.wait();  //线程2释放对象锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
		t2.setPriority(1);
		t2.start();
    }
}