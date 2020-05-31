package com;


import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;
@Slf4j
@Configuration
@SpringBootApplication
public class WSClient {

    public static void main(String[] args) {
        SpringApplication.run(WSClient.class, args);
    }
    @Bean
    public WebSocketClient webSocketClient() {
        try {
            MyWebSocketClient webSocketClient = new MyWebSocketClient(new URI("ws://127.0.0.1:8001/websocket/12/owner"));
            webSocketClient.connect();
            return webSocketClient;
        } catch (URISyntaxException e) {
            log.error("WebSocketClient is error +");
            e.printStackTrace();
        }
        return null;
    }


}
