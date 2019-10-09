package com.exchange.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * This class maps the exchange with identifier
 * @author madhu
 *
 */
@Configuration
public class NotificationExchangeConfiguration {
	
	@Value("${exchange.direct}")
    private String directExchange;
	
	@Bean
    public DirectExchange directExchange() {
        return new DirectExchange(directExchange);
    }

}
