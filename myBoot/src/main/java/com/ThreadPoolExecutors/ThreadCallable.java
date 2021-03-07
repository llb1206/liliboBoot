package com.ThreadPoolExecutors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

class FactorialCalculator implements Callable<String> {

    private Integer number;
    public FactorialCalculator(Integer number) {
        this.number = number;
    }
    public String call() {
        return number.toString();
        }
    }


public class ThreadCallable {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int rand = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(rand);
            Future<String> res = executor.submit(factorialCalculator);//异步提交, non blocking.
            resultList.add(res);
        }
        System.out.println(resultList.toString());
        executor.shutdown();
    }
}