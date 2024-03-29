package com.client.receiver;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.client.model.EventLog;
import com.client.repository.EventLogCrudRepository;
/**
 * This class handles events in the slack queue
 * @author madhu
 *
 */
@Configuration
public class SlackEventHandlerServiceImpl implements EventHandlerService {
	
	@Autowired
	EventLogCrudRepository eventLogRepo;

	@Override
	@RabbitListener(queues="slack")
	public void listenEvent(Message message) {
		EventLog log = new EventLog();
		log.setLog(message.toString());
		eventLogRepo.save(log);
		System.out.println("Listened to message " + message);
		
	}

}
