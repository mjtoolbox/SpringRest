package com.mjtoolbox.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-17.
 */
@ServerEndpoint("/websocket/atpendpoint")
@Component
public class ATPWSEndpoint {

    private static final Logger LOG = Logger.getLogger(ATPWSEndpoint.class.getName());
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String onMessage(String message) {
        if (message != null) {
            if (message.equals("HELLO SERVER")) {
                return "{\"hello\": \"Hello, if you need the ATP list just press the button ...\"}";
            } else if (message.equals("ATP SERVER")) {
                return "[{\"name\": \"Nadal, Rafael (ESP)\", \"email\": \"nadalrafael@gmail.com\", \"rank\": \"1\"},"
                        + "{\"name\": \"Djokovic, Novak (SRB)\", \"email\": \"djokovicnovak@gmail.com\", \"rank\": \"2\"},"
                        + "{\"name\": \"Federer, Roger (SUI)\", \"email\": \"federerroger@gmail.com\", \"rank\": \"3\"},"
                        + "{\"name\": \"Wawrinka, Stan (SUI)\", \"email\": \"wawrinkastan@gmail.com\", \"rank\": \"4\"},"
                        + "{\"name\": \"Ferrer, David (ESP)\", \"email\": \"ferrerdavid@gmail.com\", \"rank\": \"5\"}]";
            }
        }
        return "";
    }

    @OnOpen
    public void onOpen(Session peer) {
        LOG.info("Connection opened ...");
        peers.add(peer);
    }

    @OnClose
    public void onClose(Session peer) {
        LOG.info("Connection closed ...");
        peers.remove(peer);
    }

}
