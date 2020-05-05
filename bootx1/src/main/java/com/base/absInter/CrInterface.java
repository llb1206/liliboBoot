package com.base.absInter;

public interface CrInterface {

    //    public CrInterface(){     //接口不能有构造器
    //    }
    static int a = 3;//可以有成员变量

    // static  接口不能final
    public void run();//接口都是抽象的，不存在方法的实现

    static void fly() {
    }  //接口可以有静态方法

    //   mian       接口里不能有main  ,不能运行它
    void wack();      //接口默认都是被   public  abstract修饰
}
