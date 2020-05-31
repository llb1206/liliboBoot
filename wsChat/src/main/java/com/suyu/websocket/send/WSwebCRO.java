package com.suyu.websocket.send;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WSwebCRO {

    @Autowired
    private WebSocketClient webSocketClient;

    //http://127.0.0.1:8086/sub
    @GetMapping("sub")
    public String subscribe() {

        int a = 0;
        while (a < 100000){
            a++;
            webSocketClient.send("hello sever，i want subscribe data A"+a);
        }

        return "发送订阅成功！！！";
    }
}
