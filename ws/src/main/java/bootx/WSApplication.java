package bootx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ws客户端extends WebSocketClient
 * ws服务端打@ServerEndpoint("/websocket/{id}")注解
 */
@SpringBootApplication
public class WSApplication {

    public static void main(String[] args) {
        SpringApplication.run(WSApplication.class, args);
    }

}
