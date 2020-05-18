package com.lambda;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain=true)//链式调用噢
public class Student {
    public  static List<Student> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"刘备",18,90.4,"女"));
        list.add(new Student(2,"张飞",19,87.4,"男"));
        list.add(new Student(3,"关羽",21,67.4,"女"));
        list.add(new Student(4,"赵云",15,89.4,"女"));
        list.add(new Student(5,"马超",16,91.4,"男"));
        list.add(new Student(6,"曹操",19,83.4,"女"));
        list.add(new Student(7,"荀彧",24,78.4,"男"));
        list.add(new Student(8,"孙权",26,79.4,"女"));
        list.add(new Student(9,"鲁肃",21,93.4,"男"));
        return list;
    }


    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private Double score;
    public Student() {
    }
    public Student(Integer id, String name, Integer age, Double score,String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.sex = sex;
    }
}