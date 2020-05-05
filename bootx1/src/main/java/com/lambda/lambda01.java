package com.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class lambda01<list> {
    /**
     * Lambda的组成 编程窍门
     */

    /**
     * //工具类  Collections.addall()
     * @param args
     */
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();

        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        list.stream().forEach(a -> {
            System.out.println(a);
        });
    }

    public static void main2(String[] args) {

        String str = "as,dwq,eax,zdas";
        String[] strs = str.split(",");

        List<String> list2 = Arrays.asList(str.split(","));
        List<String> list = new ArrayList<>();
        list.stream().distinct().collect(Collectors.toSet());//快速转换为set集合
        Set asd =  new HashSet();
        asd.stream().collect(Collectors.toList());
        list.forEach(System.out::println);
        String[] strs22  = (String[]) list.toArray();
        list = Arrays.asList("asd", "wqe");
        String[] xxx = (String[]) list.toArray();
        Arrays.stream(xxx) .forEach(h->System.out.println(h));

        list2.forEach(a->{
            System.out.println(a);
        });
    }

    public static void mainsss(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new Student().setAge(i + 10).setName("yiqq" + i));
        }  //快速创建一个对象集合
        String x1 = "awe";

        list.stream().filter(a->a.getId()>0).forEach(a-> System.out.println(a.getId()));//filet 过滤遍历

        Student student = list.stream().filter(a -> "yiqq0".equals(a.getName())).findFirst().orElse(null);
        System.out.println(student);
        //返回Optional
        Optional<Student> firstA = list.stream().filter(a -> "yiqq0".equals(a.getName())).findFirst();
        Student stu = firstA.orElse(null);
        System.out.println(stu);
        //获取对象
        if (firstA.isPresent()) {
            Student stus = firstA.get();
            System.out.println(stus);
        }
        //返回集合
        List<Student> studentList = list.stream().filter(a -> "yiqq0".equals(a.getName())).collect(Collectors.toList());
        System.out.println(studentList);
        //取对象中所有的id的集合
        List<Integer> integerList = list.stream().map(Student::getAge)
                .distinct().collect(Collectors.toList());//distinct去重
        System.out.println(integerList);
    }
}
