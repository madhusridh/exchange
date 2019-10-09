package com.exchange.controller;

import javax.validation.constraints.NotEmpty;

/**
 * This POJO represents an incoming message and its attributes
 * @author madhu
 *
 */
public class Message {
	@NotEmpty
	String from;
	@NotEmpty
	String to;
	@NotEmpty
	String messageSubject;
	String messageBody;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getMessageBody() {
		return messageBody;
	}
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

}
