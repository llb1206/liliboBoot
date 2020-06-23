package com;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Configuration
@RestController
public class WebSocketController {

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            MyWebSocketClient webSocketClient = new MyWebSocketClient(new URI("ws://127.0.0.1:8001/websocket/1"));
            webSocketClient.connect();
            return webSocketClient;
        } catch (URISyntaxException e) {
            log.error("WebSocketClient is null ");
            e.printStackTrace();
        }
        return null;
    }


    @Autowired
    private WebSocketClient webSocketClient;

    //http://127.0.0.1:8002/subscribe
    @GetMapping("subscribe")
    public void subscribe() {
        webSocketClient.send("来自M78星云的ws客户短讯....请查收");
        log.info("\n");
        log.info("客户端向服务端发送成功.....\n");
        log.info("\n");
    }
}
