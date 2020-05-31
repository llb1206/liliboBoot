package com;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WebSocketController {

    @Autowired
    private WebSocketClient webSocketClient;

    //http://127.0.0.1:8002/subscribe
    @GetMapping("subscribe")
    public String subscribe() {
        webSocketClient.send("hello sever，i want subscribe data A");
        return "发送订阅成功！！！";
    }
}
