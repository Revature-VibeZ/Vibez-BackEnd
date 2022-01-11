package com.revature.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.DAOs.ChatMessageDao;
import com.revature.models.ChatMessage;


@RestController
@RequestMapping("/chat")
@CrossOrigin("*")
public class ChatController {

	private ChatMessageDao cd;
	public ChatController(ChatMessageDao cd) {
		this.cd = cd;
	}
	
	
	@MessageMapping("/hello")
	@SendTo("/message")
	public String greeting(ChatMessage message) throws Exception {
		String userMessage = message.getUsername() + ": " + message.getMessage();
		cd.save(message);
		return userMessage;
	}
	
	@GetMapping
	public ArrayList<String> getTop() {			
		ArrayList<String> history = new ArrayList<String>();		
		for(ChatMessage m : cd.findAll()) {
			System.out.println("loop");
		    history.add(m.getUsername()+" : "+ m.getMessage());
		}
		return history;
	}

}
