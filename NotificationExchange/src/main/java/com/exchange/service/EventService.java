package com.exchange.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.exchange.controller.Message;
/**
 * This service class puts the message into appropriate exchange
 * @author madhu
 *
 */
@Configuration
public class EventService {
	
	@Value("${exchange.direct}")
    private String directExchange;
	
	@Value("${routing.direct.1}")
    private String emailRoute;
	
	@Value("${routing.direct.2}")
    private String slackRoute;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	/**
	 * This method puts the message to appropriate queue 
	 * @param message
	 */
	public void raiseEvent(Message message) {
		// The below logic currently uses the range of the "to" parameter in the message to 
		// determine the route. This will be picked based on subscriber preference from dB in future 
		String routingKey = "DEFAULT";
		if(message.getTo().contains("@")) {
			routingKey = emailRoute;
		}else {
			routingKey = slackRoute;
		}
		rabbitTemplate.convertAndSend(directExchange, routingKey, message);
		
	}

}
