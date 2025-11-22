package com.ext.jms;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.jms.TemporaryQueue;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class RequestReplyDynamicQueue {

/**
	+-----------+          +----------------+          +-----------+
	| Producer1 |  ----->  | requestQueue   |  ----->  | Consumer  |
	+-----------+          +----------------+          +-----------+
	       |                                                        |
	       |                                                        v
	       |              +----------------+          +-----------+
	       |              | replyQueue     | <--------| Consumer  |
	       |              +----------------+          +-----------+
	       |
	       v
	+-------------------+
	| Message Store     |
	| (Correlation IDs) |
	+-------------------+
 */

	public static void main(String[] args) throws NamingException, JMSException {
		
		InitialContext context = new InitialContext();
		Queue queue = (Queue) context.lookup("queue/requestQueue");
		//Queue replyQueue = (Queue) context.lookup("queue/replyQueue");
		
		try(ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()){
			
			JMSProducer producer = jmsContext.createProducer();
			
			//Created dynamic queue
			TemporaryQueue replyQueue = jmsContext.createTemporaryQueue();
			
			
			TextMessage message = jmsContext.createTextMessage("Arise Awake and stop not till the goal is reached");
			//Set reply queue in header
			message.setJMSReplyTo(replyQueue);
			producer.send(queue,message);
			System.out.println(message.getJMSMessageID());
			
			//save message and it id for tracking purpose
			Map<String,TextMessage> requestMessages = new HashMap<>();
			requestMessages.put(message.getJMSMessageID(), message);
			
			JMSConsumer consumer = jmsContext.createConsumer(queue);
			TextMessage messageReceived = (TextMessage) consumer.receive();
			System.out.println(messageReceived.getText());
			
			JMSProducer replyProducer = jmsContext.createProducer();
			TextMessage replyMessage = jmsContext.createTextMessage("You are awesome!!");
			replyMessage.setJMSCorrelationID(messageReceived.getJMSMessageID());

			// use replied queue
			replyProducer.send(messageReceived.getJMSReplyTo(), replyMessage);
			System.out.println(messageReceived.getJMSReplyTo());
			
			JMSConsumer replyConsumer = jmsContext.createConsumer(replyQueue);
			//System.out.println( replyConsumer.receiveBody(String.class));
			TextMessage replyReceived = (TextMessage) replyConsumer.receive();
			System.out.println(replyReceived.getJMSCorrelationID());
			System.out.println(requestMessages.get(replyReceived.getJMSCorrelationID()).getText());
			
		}

	}
}
