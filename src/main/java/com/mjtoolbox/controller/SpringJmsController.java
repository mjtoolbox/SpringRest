package com.mjtoolbox.controller;

import com.mjtoolbox.msgClient.MessageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

/**
 * Project: springrest
 * Description: This class allows client side invocation of JMS call via REST URL
 * Created by mijo on 2015-06-29.
 */
@RestController
@RequestMapping("/jms")
public class SpringJmsController {

    @Autowired
    private Queue messageQueue;

    @Autowired
    private Topic messageTopic;

    @Autowired
    private MessageClient client;

    @Autowired
    private ConnectionFactory cf;

    @RequestMapping(value = "/send/{msg}", method = RequestMethod.GET)
    public void sendMessageToTopic(@PathVariable String msg) throws JMSException {

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
