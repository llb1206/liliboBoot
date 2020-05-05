package com.lambda;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)//链式调用噢
public class Student {
    private Integer id;
    private String name;
    private Integer age;
    private Double score;
    public Student() {
    }
    public Student(Integer id, String name, Integer age, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
    //getter和setter方法
    //toString方法
}