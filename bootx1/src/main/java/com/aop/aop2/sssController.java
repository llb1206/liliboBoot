package com.aop.aop2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class sssController {

    @Autowired
    sss ss;
    int a;
    @GetMapping("s3")
    public  int ss(String name,String pass) throws Exception {
        try {
             a= ss.ss();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("yichang"+e);
        }

    return a;
    }
}