package com.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class ProxyTest {
    public static void main(String[] args) {

        //     将要    被代理的对象
        Person px = new Student("林浅");

        //创建一个与代理对象相关联的InvocationHandler
        InvocationHandler stuHandler = new StuInvocationHandler<>(px);

        //创建一个代理对象stuProxy来代理linqian，代理对象的每个执行方法都会替换执行Invocation中的invoke方法
        Person stuProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class}, stuHandler);

        //代理执行交作业的方法
        stuProxy.giveTask("test");
        //stuProxy.giveTask2("test222");
    }
}
