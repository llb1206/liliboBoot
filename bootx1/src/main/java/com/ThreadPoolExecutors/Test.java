package com.ThreadPoolExecutors;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    private static AtomicInteger num = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(1000);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("increment-pool-%d").build();
        ExecutorService poolexecutor = new ThreadPoolExecutor(1000, 1000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        Future<String> submit = null;
        for (int i = 0; i < 1000; i++) {
            if (submit != null && submit.get() != null) {
                latch.countDown();
                continue;
            }
            submit = poolexecutor.submit(() -> {
                try {
                    //这里模拟一个耗时很长的操作
                    num.getAndIncrement();
                    //int a = 1 / 0;
                    Thread.sleep(1);
                    return null;
                } catch (Exception e) {
                    return e.toString();
                } finally {
                    latch.countDown();
                }
            });
        }
        poolexecutor.shutdown();
        //主线程等待所有分线程执行完毕后再执行
        latch.await();
        String errorMsg = submit.get();
        //如果子线程在执行过程中有错误，则在此抛出该异常
        if (errorMsg != null) {
            throw new RuntimeException(errorMsg);
        }
        System.out.println(num);
    }
}