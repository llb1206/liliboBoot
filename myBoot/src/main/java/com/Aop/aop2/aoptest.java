package com.Aop.aop2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class aoptest {
    @GetMapping("sss")
    public void ss(String name,String password){
        System.out.println(name);
        System.out.println("NO.1启动");
    }
}
