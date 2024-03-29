package com.client.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
/**
 * This service class listens to messages in the email queue 
 * @author madhu
 *
 */

import com.client.model.EventLog;
import com.client.repository.EventLogCrudRepository;
@Configuration
public class EmailEventHandlerServiceImpl implements EventHandlerService{
	@Autowired
	EventLogCrudRepository eventLogRepo;
	/**
	 * This method listens to the email queue and triggers email service
	 * @param message
	 */
	
	@RabbitListener(queues="email")
	public void listenEvent(Message message) {
		EventLog log = new EventLog();
		log.setLog(message.toString());
		eventLogRepo.save(log);
		System.out.println("Listened to message " + message);
	}

}
