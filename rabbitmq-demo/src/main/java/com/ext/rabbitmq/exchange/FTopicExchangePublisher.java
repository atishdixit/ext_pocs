package com.ext.rabbitmq.exchange;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class FTopicExchangePublisher {

	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		String mesage = "Hello Atish message to exchanges";
		
		channel.basicPublish("Fanout-Exchange-demo", ""	, null, mesage.getBytes());
		channel.close();
		connection.close();
	}

}
