package com.mjtoolbox.websocketjms;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

/**
 * Project: springrest
 * Description:
 * Created by mijo on 2015-07-14.
 */
@Stateless
public class TopicSenderSessionBean {

    @Resource(mappedName = "java:app/jms/topic")
    private Topic messageTopic;

    @Inject
    private ConnectionFactory cf;

    @Inject
    private WebSocketMDB client;

    public void sendMessage(String msg) {

        Connection connection = null;

        try
        {
            connection = cf .createConnection();
            Session session = connection .createSession( false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer publisher = session.createProducer(messageTopic);
            MessageConsumer subscriber = session.createConsumer(messageTopic);

            subscriber.setMessageListener(client);
            connection.start();

            ObjectMessage message = session.createObjectMessage( new String("Hello there it is a new message!!! " + msg));
            publisher.send(message);

        }
        catch(JMSException e )
        {
            System.out.println("Error - " + e.getMessage());
            e.printStackTrace();
        }
        finally{
            if(connection != null){
                try{
                    connection.close();
                }catch(JMSException e){
                    System.out.println("Unexpected error while trying to close the connection" + e.getMessage());
                }
            }
        }

    }
}
