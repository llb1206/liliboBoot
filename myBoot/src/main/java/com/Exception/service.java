package com.Exception;

import org.springframework.stereotype.Service;

@Service
public class service {
    public void test() throws Exception {
        try {
            int o = 1/0;
        }catch (Exception e){
           // e.printStackTrace();
           throw  new Exception("service Exception");
        }
    }
}
