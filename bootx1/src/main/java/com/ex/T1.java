package com.ex;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class T1 {
    @RequestMapping("ABC")
    public String ABC(){
        return "Hello World";
    }
}
