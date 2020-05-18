package com.Aop.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class IndexController {
    @GetMapping("ss")
    public  List<String> ss(String name,String pass){
    System.out.println("**************************"+name+"**************"+pass);
    List<String> x = Arrays.asList("qwe64","qwe87d978","awd789456");
    return x;
    }
}