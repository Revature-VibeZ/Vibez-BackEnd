package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.ChatMessage;

@SpringBootTest
public class ChatMessageTest {
	
	@Test
	public void test_setters_getters_chat_message_username() {
		
		String username = "usertest";
		String message = "testmessage";
				
		ChatMessage cm = new ChatMessage(username, message);
		
		assertTrue(cm.getUsername().equals(username));
	}
	
	@Test
	public void test_setters_getters_chat_message_message() {
		
		String username = "usertest";
		String message = "testmessage";
				
		ChatMessage cm = new ChatMessage(username, message);
		
		assertTrue(cm.getMessage().equals(message));
	}
	
	@Test
	public void test_setters_getters_chat_message_id() {
		
		String username = "usertest";
		String message = "testmessage";
				
		ChatMessage cm = new ChatMessage(username, message);
		cm.setId(1);
		
		assertEquals(1, cm.getId());
	}

}
