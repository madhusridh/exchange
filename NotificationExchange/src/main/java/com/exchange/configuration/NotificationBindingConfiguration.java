package com.exchange.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class binds queue with exchange and routing key
 * @author madhu
 *
 */
@Configuration
public class NotificationBindingConfiguration {
	
	 @Value("${routing.direct.1}")
	    private String emailRoutingKey;

     @Value("${routing.direct.2}")
     private String slackRoutingKey;
     
     @Bean
     public Binding bindingDirectExchangeQueueEmail(DirectExchange directExchange, Queue emailQueue) {
         return BindingBuilder.bind(emailQueue).to(directExchange).with(emailRoutingKey);
     }

     @Bean
     public Binding bindingDirectExchangeQueueSlack(DirectExchange directExchange, Queue slackQueue) {
         return BindingBuilder.bind(slackQueue).to(directExchange).with(slackRoutingKey);
     }

}
