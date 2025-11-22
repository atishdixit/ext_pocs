package com.ext.jms;

public class JMSFundamentals {

	public static void main(String[] args) throws Exception {
		JMSUtils.initializeQueue();
		JMSUtils.sendMessage("Hello.....");
		JMSUtils.receiveMessage();
		JMSUtils.close();
	}

}
