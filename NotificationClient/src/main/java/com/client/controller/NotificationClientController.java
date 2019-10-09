package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.model.EventLog;
import com.client.repository.EventLogCrudRepository;

@RestController
@RequestMapping("/message")
public class NotificationClientController {
	@Autowired
	EventLogCrudRepository eventLogRepo;
	
	@GetMapping("/")
	@ResponseBody
	public Iterable<EventLog> getMessage() {
		return eventLogRepo.findAll();
	}

}
