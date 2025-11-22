package com.ext.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSUtils {
	private static Session session = null;
	private static Queue queue = null;
	private static InitialContext initialContext = null;
	private static Connection connection = null;
	
	public static void initializeQueue() throws Exception {
		initialContext = new InitialContext();
		ConnectionFactory cf = (ConnectionFactory) initialContext.lookup("ConnectionFactory");
		connection = cf.createConnection();
		session = connection.createSession();
		queue = (Queue) initialContext.lookup("queue/myQueue");
	}
	
	public static void sendMessage(String msg) throws JMSException{
		messageProducer().send(createTextMessage(msg));
		
	}

	public static void receiveMessage() throws JMSException{
		consume();
	}
	

	private static MessageProducer messageProducer() throws JMSException{
		return  session.createProducer(queue);
	}
	
	
	private static TextMessage createTextMessage(String message) throws JMSException {
		return session.createTextMessage(message);
	}
	
	private static void consume() throws JMSException{
		MessageConsumer consumer = session.createConsumer(queue);
		connection.start();
		TextMessage messageReceived = (TextMessage) consumer.receive(5000);
		System.out.println("Message Received: " + messageReceived.getText());
	}
	
	public static void close() throws NamingException, JMSException {
		if (initialContext != null) {			
				initialContext.close();			
		}
		if (connection != null) {
				connection.close();
		}
	}

}
