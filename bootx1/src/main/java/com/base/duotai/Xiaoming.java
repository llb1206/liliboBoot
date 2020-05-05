package com.base.duotai;

public class Xiaoming extends Person {
    public String name ="子类chifan";
    public String name2 ="子类chifan";//想要输出子类私有的，需要向下转型
   // public static String names ="bbbb";
    public void eat(){
        System.out.println(name);//方法输出name，就近原则
        System.out.println("子类吃饭");
    }
    public static void eats(){
        System.out.println("子类吃饭sss");//父类引用指向子类对象时，只会调用父类的静态方法。
    }

    public static void main(String[] args) {
        Person a = new Xiaoming();
       // System.out.println(a.name);
       // Xiaoming b =(Xiaoming)a;
        //a.eats();//父类引用指向子类对象时，只会调用父类的静态方法。
        a.eat();
        //System.out.println(b.name2);
        System.out.println(Xiaoming.names);
    }
}
