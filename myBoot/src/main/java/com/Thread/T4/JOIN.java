package com.Thread.T4;

public class JOIN {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("A");
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    t1.join();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("B");
            }
        });
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    t2.join();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.out.println("C");
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

