package com.Aop.aop2;

import org.springframework.stereotype.Component;

@Component
public class sss {
    int a;
    public int ss() throws Exception {
            a=1/0;
        return a;
    }
}
