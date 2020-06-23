package com;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * java  客户端client
 */
@Slf4j
@SpringBootApplication
public class WSClient {

    public static void main(String[] args) {
        SpringApplication.run(WSClient.class, args);
    }
}
