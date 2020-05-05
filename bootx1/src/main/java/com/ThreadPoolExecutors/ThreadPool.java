package com.ThreadPoolExecutors;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class myCallable implements Callable<String> {

    @SneakyThrows
    public String call() {
        for (int i = 0; i < 30; i++){
            Thread.sleep(10);
        }
        return Thread.currentThread().getName() + " returns value";
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            try {
                myCallable myx = new myCallable();
                Future<String> task = pool.submit(myx);
                //pool.submit(myx);
                System.out.println(task.get());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        pool.shutdown();
    }
}
