package com.suyu.websocket.send;


import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@Configuration
public class WSClient {

    @Bean
    public WebSocketClient webSocketClient() {
        try {
            MyWebSocketClient webSocketClient = new MyWebSocketClient(new URI("ws://127.0.0.1:8086/socketServer/SS"));
            webSocketClient.connect();
            return webSocketClient;
        } catch (URISyntaxException e) {
            log.error("WebSocketClient is error +");
            e.printStackTrace();
        }
        return null;
    }


}
