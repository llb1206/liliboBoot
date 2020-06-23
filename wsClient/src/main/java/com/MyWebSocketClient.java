package com;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

@Slf4j
public class MyWebSocketClient extends WebSocketClient {

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        // TODO Auto-generated method stub
        log.info("------ 客户端 onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
        // TODO Auto-generated method stub
        log.info("------ 客户端 onClose ------{}",arg1);
    }

    @Override
    public void onError(Exception arg0) {
        // TODO Auto-generated method stub
        log.info("------ 客户端 onError ------{}",arg0);
    }

    @Override
    public void onMessage(String arg0) {
        // TODO Auto-generated method stub
        log.info("-------- Java-客户端： " + arg0 + "--------\n");
    }
}
