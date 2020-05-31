package bootx.ws;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;


@Slf4j
@ServerEndpoint("/websocket/{id}/{name}")
@RestController
public class WebSocketController {
    // 用来记录当前连接数的变量
    private static volatile int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<WebSocketController> webSocketSet = new CopyOnWriteArraySet<>();

    // 与某个客户端的连接会话，需要通过它来与客户端进行数据收发
    private Session session;


    @OnOpen
    public void onOpen(Session session, @PathParam("id") long id, @PathParam("name") String name) throws Exception {
        this.session = session;
        System.out.println(this.session.getId());
        webSocketSet.add(this);
        log.info("Open a websocket. id={}, name={}", id, name);
        int i=0;
        while (true) {
            i++;
            Thread.sleep(1000);
            sendMessage("hello websocket"+i);
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("Close a websocket. ");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        if (this.session.isOpen()) {
            while (true)
            this.session.getBasicRemote().sendText(message);
        }
        log.info("Receive a message from client: " + message);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Error while websocket. ", error);
    }

    public void sendMessage(String message) throws Exception {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketController.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketController.onlineCount--;
    }
}
