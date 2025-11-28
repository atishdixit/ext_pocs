package com.ext.rabbitmq.exchange;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Comsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.newConnection();
		Channel channel = connection.createChannel();
		
		DeliverCallback deliverCallback = (consumerTag, delivery)->{
			String message = new String(delivery.getBody());
			System.out.println("Message Recived :" +message);			
		};
		//  String basicConsume(String queue, boolean autoAck, DeliverCallback deliverCallback, CancelCallback cancelCallback) throws IOException;

		channel.basicConsume("Account-queue", true, deliverCallback, consumerTag->{});
		channel.basicConsume("Finance-Queue", true, deliverCallback, consumerTag->{});
		channel.basicConsume("HR-Queue", true, deliverCallback, consumerTag->{});
		
		channel.close();
		connection.close();

	}

}
