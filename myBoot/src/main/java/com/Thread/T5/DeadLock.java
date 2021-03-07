package com.Thread.T5;

/**
 如何防止死锁：

 尽量使用 tryLock(long timeout, TimeUnit unit)的方法(ReentrantLock、ReentrantReadWriteLock)，
 设置超时时间，超时可以退出防止死锁。
 尽量使用 Java. util. concurrent 并发类代替自己手写锁。
 尽量降低锁的使用粒度，尽量不要几个功能用同一把锁。
 尽量减少同步的代码块。
 */
public class DeadLock implements Runnable{
    
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    private boolean flag;
    
    public DeadLock(boolean flag){
        this.flag = flag;
    }
    
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName() + "运行");
        
        if(flag){
            synchronized(obj1){
                System.out.println(Thread.currentThread().getName() + "已经锁住obj1");
                try {  
                    Thread.sleep(1000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                synchronized(obj2){
                    // 执行不到这里
                    System.out.println("1秒钟后，"+Thread.currentThread().getName()
                                + "锁住obj2");
                }
            }
        }else{
            synchronized(obj2){
                System.out.println(Thread.currentThread().getName() + "已经锁住obj2");
                try {  
                    Thread.sleep(1000);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
                synchronized(obj1){
                    // 执行不到这里
                    System.out.println("1秒钟后，"+Thread.currentThread().getName()
                                + "锁住obj1");
                }
            }
        }
    }
    public static void main(String[] args) {

        Thread t1 = new Thread(new DeadLock(true), "线程1");
        Thread t2 = new Thread(new DeadLock(false), "线程2");

        t1.start();
        t2.start();
    }
}