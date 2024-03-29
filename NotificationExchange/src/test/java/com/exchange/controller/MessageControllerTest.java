package com.exchange.controller;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.exchange.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This is a test class that is for unit testing the POST method
 * @author madhu
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(MessageController.class)
public class MessageControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	EventService eventService;
	@Test
	public void messages_postMessage_whenArgsValid() throws Exception {
		Message message = new Message();
		message.setFrom("a@b.com");
		message.setTo("abc@gmail.com");
		message.setMessageSubject("sample subjct");
		message.setMessageBody("sample body");
		
		doNothing().when(eventService).raiseEvent(Mockito.any());
		String jsonString = new ObjectMapper().writeValueAsString(message);
		mockMvc.perform(post("/message/").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().isOk());
	}
	
	@Test
	public void messages_postMessage_whenArgsMissing() throws Exception {
		Message message = new Message();
	//	message.setFrom("a@b.com");
		message.setTo("abc@gmail.com");
		message.setMessageSubject("sample subjct");
		message.setMessageBody("sample body");
		
		doNothing().when(eventService).raiseEvent(Mockito.any());
		String jsonString = new ObjectMapper().writeValueAsString(message);
		mockMvc.perform(post("/message/").contentType(MediaType.APPLICATION_JSON).content(jsonString)).andExpect(status().is(400));
	}
	

}
