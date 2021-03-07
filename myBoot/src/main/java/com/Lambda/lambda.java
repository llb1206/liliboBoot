package com.Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class lambda<list> {

    static {
        List<Student> ss = Student.getStudents();
    }

    /**
     * 快速给一个集合添加元素，实际用处不大
     */
    public static void mains(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        list.stream().forEach(System.out::println);
    }

    /**
     * 字符串转数组，切割，转集合，stream去重,
     * 数组lambda快速遍历  Arrays.stream(str[]).foreach-----!!!
     *
     * @param args
     */
    public static void main2(String[] args) {
        String str = "as,dwq,eax,zdas";
        String[] strs = str.split(",");
        List<String> list2 = Arrays.asList(str.split(","));
        List<String> list = new ArrayList<>();
        list.stream().distinct().collect(toList());
        Set asd = new HashSet();
        asd.stream().collect(toList());
        list.forEach(System.out::println);
        String[] strs22 = (String[]) list.toArray();
        list = Arrays.asList("asd", "wqe");
        String[] xxx = (String[]) list.toArray();
        //数组lambda快速遍历  Arrays.stream(str[]).foreach
        Arrays.stream(xxx).forEach(h -> System.out.println(h));
        Arrays.stream(xxx).forEach(System.out::println);
        list2.forEach(System.out::println);
    }

    /**
     * 快速创建一个集合
     *
     * @param args
     */
    public static void main23(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            //链式调用
            list.add(new Student().setAge(i + 10).setName("yiqq" + i));
        }  //快速创建一个对象集合
        //filer 过滤遍历
        list.stream().filter(a -> a.getId() > 0).forEach(a -> System.out.println(a.getId()));
        //取对象中所有的id的集合//distinct去重
        List<Integer> integerList = list.stream().map(Student::getAge)
                .distinct().collect(toList());
        System.out.println(integerList);
    }

    /**
     * 转换过滤取值，注意用途哦
     *
     * @param args
     */
    public static void main121(String[] args) {
        List<Student> data = Student.getStudents();
        data.stream().map(Student::getAge).collect(toList()).forEach(System.out::println);
        //filter只是过滤，并不转换,map才是转换，可以换了类型
        Stream<String> xas = data.stream().filter(x -> x.getSex().equals("男")).collect(toList()).stream().map(Student::getName);
        xas.forEach(System.out::println);
    }

    public static void main2343(String[] args) {
        List<Student> data = Student.getStudents();
        Integer min = data.stream().mapToInt(Student::getAge).min().getAsInt();
        List<Student> data1 = data.stream().filter(x -> !x.getName().equals("张飞")).collect(Collectors.toList());
        data1.stream().forEach(System.out::println);
    }

    /**
     * 截取
     *
     * @param args
     */
    public static void main11asdsa(String[] args) {
        List<Student> data = Student.getStudents();
        //给每一个符合条件的增加..........
        data.stream().filter(x -> x.getAge() > 20).forEach(x -> x.setAge(x.getAge() + 10));
        //截取前三个，进行操作
        List<Student> data2 = data.stream().limit(3).collect(Collectors.toList());
        System.out.println(data2.size());
        data2.stream().count();
        System.out.println(data2.stream().count());
    }

    /**
     * data.stream().collect(Collectors.toSet());//直接转换，不多BB
     * *-*-*-*-*-
     * 互换位置x1<-->x2即可排序
     *
     * @param args
     */
    public static void main787945(String[] args) {
        List<Student> data = Student.getStudents();
        //直接转换，不多BB
        data.stream().collect(Collectors.toSet());
        data.stream().sorted((x1, x2) -> (x2.getAge() - x1.getAge())).forEach(x -> System.out.println(x));
    }

    public static void main1212(String[] args) {
        List<Student> data = Student.getStudents();
        String pp = "5645,487,564897,564813,8548";
        pp.split(",");
        List<String> x2 = Arrays.asList(pp.split(","));
        List<Integer> aa = x2.stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        Object[] ww = aa.stream().toArray();
        Arrays.stream(ww).forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Student> data = Student.getStudents();
        Student asd = data.stream().min((x1, x2) -> (x1.getAge() - x2.getAge())).get();
        //*max
        Student asd1 = data.stream().min(Comparator.comparingInt(Student::getAge)).get();
       // System.out.println(asd);
        //某一属性求和
        Double ageSum = data.stream().mapToDouble(Student::getAge).sum();
        System.out.println(ageSum);
    }
}