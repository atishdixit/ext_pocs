package com.ext.ptop.p2p.eleigibilitycheck;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

import com.ext.ptop.p2p.eleigibilitycheck.listeners.EligibilityCheckListener;
public class EligibilityCheckerApp {
	public static void main(String[] args) throws NamingException, InterruptedException {
		InitialContext initialContext = new InitialContext();
		Queue requestQueue = (Queue) initialContext.lookup("queue/requestQueue");

		try (ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
				JMSContext jmsContext = cf.createContext()) {
			JMSConsumer consumer = jmsContext.createConsumer(requestQueue);
			consumer.setMessageListener(new EligibilityCheckListener());			
						
			Thread.sleep(10000);//Waiting for message, in server we do not required

		};

	}
}
