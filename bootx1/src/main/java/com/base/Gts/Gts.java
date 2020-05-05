package com.base.Gts;

import java.util.ArrayList;
import java.util.List;

public class Gts<T> {


    public T key;

    public static <T> T asd(T asdasd) {//<T>  表示这是一个泛型方法

        return asdasd;
    }

    public static <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试 " + t);
        }
    }


    public static void main2(String[] args) {
//        List<? extends Thread> sa = new ArrayList<>();
//
//        String asd = "sad";
//        String asds = "sad";
//        int a = 1111;
//        printMsg(asd, asds, a);
        Gts xxx = new Gts<String>();
        xxx.key = 1000L;
        Class x1 = xxx.key.getClass();

        String asd[] = new String[10];

        System.out.println(x1 + "8989");
    }

    public static void oioio(){
        int i=0;
        while(true){
            i++;
            System.out.println(i);
            if(i == 10){
                break;
            }
            System.out.println("..........");
        }
    }

    public static void main(String[] args) {
        List asd = new ArrayList();
        for (int i = 0; i <10 ; i++) {
            Integer a = new Integer(i);
            asd.add(a);
        }
        oioio();
        System.out.println("*-*-*-*-");
        //asd.stream().forEach(x-> System.out.println(x));
    }
}
