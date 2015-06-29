import static org.junit.Assert.assertNotNull;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class JndiLookupTest {
    TopicSession  topicSession;
	
	@Test
	public void jndiLookup() throws NamingException, JMSException, InterruptedException {
		System.out.println("start...");
	      Properties env = new Properties();
	      env.put( Context.PROVIDER_URL, "remote://localhost:4447");
	      env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//	      env.put(Context.URL_PKG_PREFIXES, "org.jboss.as.naming.interfaces:org.jboss.ejb.client.naming");
//	      env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//	      env.put("jboss.naming.client.ejb.context", true);
//	      env.put(Context.SECURITY_PRINCIPAL, "jndiUser");
//	      env.put(Context.SECURITY_CREDENTIALS, "jndiUserPwd1!");
	      
	      
	      InitialContext initialContext = new InitialContext( env );
	        
//	      ConnectionFactory connectionFactory = (ConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
	      TopicConnectionFactory connectionFactory = (TopicConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
	      
//	      Object connectionFactory = initialContext.lookup("jms/RemoteConnectionFactory");
//	      Object connectionFactory = initialContext.lookup("InVmConnectionFactory");
	      
//	      Object connectionFactory = initialContext.lookup( "java:/ConnectionFactory" );		
//	      Object connectionFactory = initialContext.lookup( "/ConnectionFactory" );		
//	      Object connectionFactory = initialContext.lookup( "ConnectionFactory" );		
//	      Object connectionFactory = initialContext.lookup( "jms/ConnectionFactory" );		
		 
//	      Object queue = initialContext.lookup("java:/jms/queue/CMWeb.Routing.JmsQueue");
//	      Object queue = initialContext.lookup("/jms/queue/CMWeb.Routing.JmsQueue");
//	      Object queue = initialContext.lookup("jms/queue/CMWeb.Routing.JmsQueue");
//	      Object queue = initialContext.lookup("CMWeb.Routing.JmsQueue");

//	      Object queue = initialContext.lookup("jms/queue/test");
	      
	      TopicConnection conn = connectionFactory.createTopicConnection();
	      
	      Topic topic = (Topic)initialContext.lookup("CMWeb.SentPopUpMessage.JmsTopic");
//	      Topic topic = (Topic)initialContext.lookup("CMWeb.JmsTopic");
//	      TopicSession  session = conn.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
//	      TopicSession  
	      topicSession = conn.createTopicSession(false, TopicSession.CLIENT_ACKNOWLEDGE);
	      TopicPublisher publisher = topicSession.createPublisher( topic );
//	      TextMessage message = session.createTextMessage("CMWebSubSystemCode = 'DECLARATIONS' AND (EntityName = 'UnitDeclaration' OR EntityName = 'HydroUnitDeclaration'" 
//		      + " OR EntityName = 'ThermalUnitDeclaration' OR EntityName = 'OperatingMode')") ;
	      
	      ObjectMessage message = topicSession.createObjectMessage( new String("bla"));
	      message.setStringProperty( "CMWebSubSystemCode", "DECLARATIONS" );
//	      message.setStringProperty( "EntityName", "HydroUnitDeclaration" );
	      message.setStringProperty( "EntityName", "UnitDeclaration" );
	      //"IsRoutingMessage IS NULL AND MessageRecipientId IS NULL"
//	      message.setStringProperty( "MessageRecipientId", null);
	      message.setStringProperty( "IsRoutingMessage", "sth" );
	      
	      
	      publisher.publish(message);
	      publisher.close();
	      
	      assertNotNull(connectionFactory);
//	      assertNotNull(queue);
	      assertNotNull(topic);
	      
//		assertEquals("This handler is a stub of the abstract class and does not require any fields.",
//				Status.OK.getStatusCode(), response.getStatus());
	      
	      
//        	for (int i = 0; i < 10000; i++) {
//        	    // Pause for 4 seconds
//        	    Thread.sleep(4000);
//        	    // Print a message
//        	    System.out.println(" ... " + i + " ... " );
//        	}
	}
/*	
	@Test
	public void routingBeanTest() throws NamingException, JMSException, InterruptedException {
	    
//	    PopUpMessage.Routing.java.naming.security.authentication=simple
//		    PopUpMessage.Routing.java.naming.security.principal=sa-webcm
//		    PopUpMessage.Routing.java.naming.security.credentials=Password
	    
	      System.out.println("start...");
	      Properties env = new Properties();
	      env.put( Context.PROVIDER_URL, "remote://localhost:4447");
	      env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
//	      env.put(Context.URL_PKG_PREFIXES, "org.jboss.as.naming.interfaces:org.jboss.ejb.client.naming");
//	      env.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//	      env.put("jboss.naming.client.ejb.context", true);
	      env.put(Context.SECURITY_PRINCIPAL, "jndiUser");
	      env.put(Context.SECURITY_CREDENTIALS, "jndiUserPwd1!");
	      
	      
	      InitialContext initialContext = new InitialContext( env );
	        
	      TopicConnectionFactory connectionFactory = (TopicConnectionFactory) initialContext.lookup("jms/RemoteConnectionFactory");
	      TopicConnection conn = connectionFactory.createTopicConnection();
	      
	      Topic topic = (Topic)initialContext.lookup("CMWeb.SentPopUpMessage.JmsTopic");
	      topicSession = conn.createTopicSession(false, TopicSession.CLIENT_ACKNOWLEDGE);
	      TopicPublisher publisher = topicSession.createPublisher( topic );
	      
	      ObjectMessage message = topicSession.createObjectMessage( new String("bla"));
	      message.setStringProperty( "CMWebSubSystemCode", "DECLARATIONS" );
	      message.setStringProperty( "EntityName", "UnitDeclaration" );
	      message.setStringProperty( "IsRoutingMessage", "sth" );
	      
	      publisher.publish(message);
	      publisher.close();
	      
	      assertNotNull(connectionFactory);
	      assertNotNull(topic);
	      
	}
*/
}