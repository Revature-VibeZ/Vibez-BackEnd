package com.revature.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import com.revature.models.ChatMessage;
import com.revature.models.User;

@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {
	public static ArrayList<String> history = new ArrayList<String>();

	@MessageMapping("/hello")
	@SendTo("/message")
	public String greeting(ChatMessage message) throws Exception {
		System.out.println("321321");
//		Thread.sleep(1000); // simulated delay	
		String userMessage = message.getUsername() + ": " + message.getMessage();
		history.add(userMessage);		
		return userMessage;
	}
	
	@GetMapping
	public ArrayList<String> getTop() {		
		
		return history;
	}

}
