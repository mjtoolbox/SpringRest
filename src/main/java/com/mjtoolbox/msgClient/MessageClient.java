package com.mjtoolbox.msgClient;

import com.mjtoolbox.bean.WebsocketJMS;
import org.springframework.stereotype.Component;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
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


//    @Inject
//    @WebsocketJMS
//    Event<Message> jmsEvent;

    public void onMessage(Message message) {

//        jmsEvent.fire(message);

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
