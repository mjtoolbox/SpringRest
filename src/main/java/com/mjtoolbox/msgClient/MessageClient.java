package com.mjtoolbox.msgClient;

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


    public void onMessage(Message message) {

        ObjectMessage text = (ObjectMessage)message;
        String strMessage = null;
        try {
            strMessage = (String)text.getObject();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Message received: "+strMessage);
    }
}
