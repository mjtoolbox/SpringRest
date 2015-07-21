package com.mjtoolbox.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjtoolbox.service.SpringRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-17.
 */
@ServerEndpoint("/websocket/myService")
@Component
public class NgWebsocketController {


    private SpringRestService springRestService = new SpringRestService();

    private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String retrieveData(String msg, final Session client) {
//        System.out.println("*** Websocket client sent: " + msg );
//        return ("Echo back from websocket Server Endpoint" );

        ObjectMapper mapper = new ObjectMapper();
        String jsonValue = null;
        try {
            List<com.mjtoolbox.bean.Message> list = springRestService.getAllEvents();
            System.out.println("List size: " + list.size());
            jsonValue = mapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonValue;

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
