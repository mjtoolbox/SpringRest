This sample project is to use Spring REST back end and AngularJS front end. 
Problem description - Multiple users login to the system. They have notification windows (message console). Based on the event, JMS message is created from backend and publish to either Queue or Topic based on the business logic. Some of events must deliver to users' notification window and allow users to take action.

[Solution] JMS subscriber call WebSocket ServerEndpoint's method, which will send translated JMS message (String format) to WebSocket client through already established WebSocket channel.

To achieve the same result, I also investigated few other options.
[Option 1]  STOMP + SockJS + Spring 4.x
Above technology combination works well on Tomcat. However, it has a problem identifying WebSocket endpoint. SockJS connection can not be established and throws error 404.
[Option 2] STOMP on HornetQ
I enabled HornetQ and tried to use STOMP. Later I learned that officially JBoss EAP 6.x doesn't support STOMP. Also, the way HornetQ enables the STOMP using WebSocket (by allowing jms.topic.xxx and jms.queue.xxx) doesn't work with JMS topic. I believe there is an interoperability issue in HornetQ. Theoratically, STOMP jms topic or JMS topic should be shared, so server side published message can be subscribed by client side. This only worked between client side.


Prerequisite
* IE11 has a problem interpreting <output> tag. IE11 will not refresh the page. Use Chrome instead.
* JBoss 6.2 doesn't work with WebSocket. I used JBoss 6.4. 6.3 also works.
* Configure JBoss 6.4 by running below command.
jboss-cli --connect --file=configure-http-connector.cli
* Add "queue/test", "topic/test" in the standalone-full.xml

                <jms-destinations>
                    <jms-queue name="ExpiryQueue">
                        <entry name="java:/jms/queue/ExpiryQueue"/>
                    </jms-queue>
                    <jms-queue name="DLQ">
                        <entry name="java:/jms/queue/DLQ"/>
                    </jms-queue>
                    <jms-queue name="testQueue">
                        <entry name="queue/test"/>
                        <entry name="java:jboss/exported/jms/queue/test"/>
                    </jms-queue>
                    <jms-topic name="testTopic">
                        <entry name="topic/test"/>
                        <entry name="java:jboss/exported/jms/topic/test"/>
                    </jms-topic>
                </jms-destinations>

* Start JBoss with standalone-full.xml by running below command.
standalone.bat -c standalone-full.xml


Step to test
1. Open up WebSocket client in the browser. localhost:8080/springrest/index.html
2. Open connection.
3. Test by sending message to ServerEndpoint.
4. Open up another tab in the browser. localhost:8080/springrest/spring/jms/send/{yourmessage}
This will invoke JMS call and send message to Topic. Subscriber receives the message and send message to WebSocket client.
5. Message from JMS shows up on WebSocket client message page.


To Do
[HTML]
1. New page with AngularJS-Websocket
2. Handle ction from HTML to back en

[WebSocket Server Endpoint]
2. Add error handling
3. Analyze Message type & Delivery point based on the user

[REST Spring]
4. Possibly injecting legacy code: http://stackoverflow.com/questions/3813588/how-to-inject-dependencies-into-a-self-instantiated-object-in-spring


