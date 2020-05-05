package com.base.Collection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestBox {

    public static void main(String[] args){
        List<String> arrayList = new ArrayList<String>();
        List<String> arrayList3 = new ArrayList<String>();
        arrayList.add("s");
        arrayList.add("e");
        arrayList.add("n");
        /**
         * ArrayList转数组
         */
        int size=arrayList.size();
        //转数组  用toArray（）；
        String[] a = arrayList.toArray(new String[size]);//相互转换
        arrayList3 = Arrays.asList(a);//相互转换
        //输出第二个元素
        System.out.println(a[1]);//结果：e
        //输出整个数组
        System.out.println(Arrays.toString(a));//结果：[s, e, n]
        /**
         * 数组转list
         */
        List<String> list= Arrays.asList(a);
        /**
         * list转Arraylist
         */
        List<String> arrayList2 = new ArrayList<String>();
        arrayList2.addAll(list);
        System.out.println(list);
    }
}