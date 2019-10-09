package com.client.receiver;

import org.springframework.amqp.core.Message;

public interface EventHandlerService {
	
	public void listenEvent(Message message);

}
