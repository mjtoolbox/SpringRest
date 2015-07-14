package com.mjtoolbox.websocketjms;

import com.mjtoolbox.bean.WebsocketJMS;

import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-14.
 */
@JMSDestinationDefinition(
        name = "java:app/jms/myQueue",
        interfaceName = "javax.jms.Queue",
        destinationName = "myQueue"
)
@MessageDriven(mappedName = "java:app/jms/myQueue")
public class WebSocketMDB implements MessageListener {

    @Inject
    @WebsocketJMS
    Event<Message> jmsEvent;

    @Override
    public void onMessage(Message msg) {
        jmsEvent.fire(msg);
    }

}
