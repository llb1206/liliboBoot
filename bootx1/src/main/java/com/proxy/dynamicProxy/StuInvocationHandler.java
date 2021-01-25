package com.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuInvocationHandler<T> implements InvocationHandler {
    //invocationHandler持有的被代理对象
    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "前置通知");
        System.out.println(method.getReturnType()+ "前置通知");
        System.out.println("参数" + args[0]);
        System.out.println("参数数量"+method.getParameterCount());
        System.out.println("参数类型"+method.getParameterTypes().getClass());
        System.out.println("参数类型2"+method.getTypeParameters());
        Object result = method.invoke(target, args);
        System.out.println("代理执行" + method.getName() + "后置通知");
        return result;
    }
}
