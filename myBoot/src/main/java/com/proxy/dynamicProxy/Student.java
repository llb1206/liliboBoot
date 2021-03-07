package com.proxy.dynamicProxy;

public class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void giveTask(String uu) {
        System.out.println(name + "交语文作业");
    }

    @Override
    public String giveTask2(String uu) {
        System.out.println(name + "交语文作业22222");
        return "success";
    }

    public void fuck() {
        System.out.println(name + "fucking............");
    }
}
