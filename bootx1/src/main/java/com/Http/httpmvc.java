package com.Http;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class httpmvc {
    @PostMapping("httpv1")
    public String asd(@RequestBody String x){
        System.out.printf(""+x);
        return "httpClient";
    }
    @PostMapping("httpv2")
    public String asda(String userId,String pa){
        System.out.printf(userId+"/*/**/"+pa);
        return "httpClient";
    }
}
