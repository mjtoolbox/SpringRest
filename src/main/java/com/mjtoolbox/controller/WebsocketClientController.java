package com.mjtoolbox.controller;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-14.
 */
@ClientEndpoint
public class WebsocketClientController {

    @OnOpen
    public void onOpen(Session session) {
        try {
            String name = "Duke";
            System.out.println("Sending message to endpoint: " + name);
            session.getBasicRemote().sendText(name);
        } catch (IOException ex) {
            System.out.println();
        }
    }


    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("mesage = " + message);
    }
}
