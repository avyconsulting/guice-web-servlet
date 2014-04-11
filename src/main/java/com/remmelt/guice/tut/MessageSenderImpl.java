package com.remmelt.guice.tut;

public class MessageSenderImpl implements MessageSender {
	@Override
	public String sendMessage(String msg) {
		return "Message sent: " + msg;
	}
}
