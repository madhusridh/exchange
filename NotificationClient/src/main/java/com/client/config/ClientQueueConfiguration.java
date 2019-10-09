package com.client.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 * 
 * @author madhu
 *
 */
@Configuration
public class ClientQueueConfiguration {
	
	@Value("${queue.1}")
	private String emailQueue;
	@Value("${queue.2}")
	private String slackQueue;
	
	@Bean
	  public Queue emailQueue() {
	    return new Queue(emailQueue);
	  }
	
	@Bean
	  public Queue slackQueue() {
	    return new Queue(slackQueue);
	  }


}
