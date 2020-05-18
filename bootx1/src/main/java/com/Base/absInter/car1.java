package com.Base.absInter;

public class car1 extends Car {
    int b = 5;

    @Override
    protected void flying() {
        System.out.println("2222");
    }

    protected void fly() {
        System.out.println("2222");
    }

    @Override
    public void going() {

    }


    @Override
    void backing() {
        System.out.println("1111");
    }

    public static void main(String[] args) {
        Car s = new car1();
        s.fly();
        s.run();//调用的是父类的  不能被继承final
        System.out.println(s.b);
    }
}
