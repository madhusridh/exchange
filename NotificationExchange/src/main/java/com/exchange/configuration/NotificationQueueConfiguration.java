package com.exchange.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to configure the various direct queues used by the application 
 * @author madhu
 *
 */
@Configuration
public class NotificationQueueConfiguration {
	
	@Value("${queue.1}")
	private String emailQueue;
	@Value("${queue.2}")
	private String slackQueue;
	/**
	 * This method creates a new queue and initializes the name of the queue to email
	 * @return
	 */
	@Bean
	public Queue emailQueue() {
		return new Queue(emailQueue);
	}
	/**
	 * This method creates a new queue and initializes the name of the queue to slack
	 * @return
	 */	
	@Bean
	public Queue slackQueue() {
		return new Queue(slackQueue);
	}
	
}
