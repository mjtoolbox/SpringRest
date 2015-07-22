package com.mjtoolbox.controller;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-14.
 */
@ServerEndpoint("/websocket/helloName")
@Component
public class WebsocketController implements Serializable {

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String sayHello(String name, final Session client) {

        System.out.println("Say hello to '" + name + "'");
        return ("Hello " + name + " from websocket Server Endpoint");
    }

    @OnOpen
    public void helloOnOpen(Session session) {
        sessions.add(session);
        System.out.println("WebSocket opened: " + session.getId());
    }

    @OnClose
    public void helloOnClose(final Session session, CloseReason reason) {
        sessions.remove(session);
        System.out.println("Closing a WebSocket due to " + reason.getReasonPhrase());
    }

    public void sendMsgToClient(Message msg) {

        for (Session s : sessions) {
            try {
                ObjectMessage object = (ObjectMessage) msg;
                String result = (String) object.getObject();

                s.getBasicRemote().sendText("Horray! message from JMS: " + result);
            } catch (Exception e) {
                System.out.println("Exception : " + e);
            }

        }

    }

}