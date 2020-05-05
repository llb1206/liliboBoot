package com.httpres;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

@RestController
public class GuaController {
    @GetMapping("str")
    public ResponseData str() {
        return ResponseDataUtil.buildSuccess("Result String");
    }

    @GetMapping("data")
    public ResponseData data() {
        return ResponseDataUtil.buildSuccess(Arrays.asList("asd","aswqe","asdjjo"));
    }


    @GetMapping("map")
    public ResponseData map() {
        HashMap<String, Object> map = new HashMap<>(1);
        map.put("k", "Map");
        JSONObject result = new JSONObject(map);
        String a = new String("asd");
        String b = new String("asd");
        return ResponseDataUtil.buildSuccess(a == (b));
    }


}