package com.FilterParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liliBo
 * @date 2020/5/14 11:22
 * @Description
 */
@RestController
public class xx {
    //http://localhost:8080/xx?asd=%20%20%20dd%20%20
    @GetMapping("xx")
    public void yusia(String asd) {
        System.out.println(asd);
    }
}
