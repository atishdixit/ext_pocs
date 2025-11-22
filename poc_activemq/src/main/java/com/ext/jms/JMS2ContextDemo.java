package com.ext.jms;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class JMS2ContextDemo {

	public static void main(String[] args) throws Exception {
			InitialContext context = new InitialContext();
			Queue queue = (Queue) context.lookup("queue/myQueue");
			
			try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
					JMSContext jmsContext = cf.createContext()){
				jmsContext.createProducer().send(queue,"Arise Awake and stop not till the goal is reached");
				String messageReceived = jmsContext.createConsumer(queue).receiveBody(String.class);
				System.out.println(messageReceived);
			}

		}
}
