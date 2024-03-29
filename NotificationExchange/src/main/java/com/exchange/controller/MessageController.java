package com.exchange.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.service.EventService;
/**
 * This is the generic controller class that exposes a REST API for messages to flow through the application
 * @author madhu
 *
 */
@RestController
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	EventService eventService;
	
	/**
	 * This method handles a new incoming message from third party
	 * @param message
	 * @return
	 */
	@PostMapping(path="/",consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addMessage(@Valid @RequestBody Message message) {
		eventService.raiseEvent(message);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
