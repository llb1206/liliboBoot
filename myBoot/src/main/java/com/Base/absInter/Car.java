package com.Base.absInter;

public abstract  class Car extends Object implements Runnable {

    /**
     * 可以理解成半成品
     * 抽象类完成了类中主要功能的设计与实现，但是这个类还觉得不够完美，还应该有一些功能（方法），等待后续子类的实现。
     */
    static {
        System.out.printf("抽象方法可以拥有静态代码块");
    }

    static int a = 3;  //也可以有静态变量
    int b = 4;         //可以有普通变量，

    public Car() {         //抽象类可以有构造方法
    }

    public final void run() {
        System.out.println("抽象类的run");
    }

    protected void fly() {   //可以使用 protected修饰
        System.out.println("抽象类的run");
    }

    private final void think() {           //不能加default修饰
        System.out.println("抽象类的run");
    }

    protected abstract void flying();//抽象方法不能有方法体，protected修饰，可以被public修饰，也可以被defualt修饰？？

    public abstract void going();   //抽象方法不能有方法体，public 公共

    abstract  void backing();       //抽象方法不能有方法体，

    public static void main(String[] args) {   //抽象发放可以拥有main方法，并且可以运行静态，但是不能实例你懂的

        System.out.println(Car.a + "抽象方法可以拥有静态变量，并且可以在抽象类的的main方法中运行");

    }
}
