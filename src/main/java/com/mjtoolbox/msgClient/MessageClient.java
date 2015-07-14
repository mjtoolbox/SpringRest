package com.mjtoolbox.msgClient;

import com.mjtoolbox.controller.WebsocketController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-06-29.
 */
@Component
public class MessageClient implements MessageListener {

//    @Autowired
//    private WebsocketController serverEndpoint;

    public void onMessage(Message message) {

//        serverEndpoint.sendMsgToClient(message);

        ObjectMessage text = (ObjectMessage) message;
        String strMessage = null;
        try {
            strMessage = (String) text.getObject();


        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("************** Message received: " + strMessage);
    }
}
