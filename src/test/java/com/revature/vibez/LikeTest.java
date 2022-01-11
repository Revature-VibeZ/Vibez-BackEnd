package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Like;

@SpringBootTest
public class LikeTest {
	
	@Test
	public void test_getters_setters_likeId() {
		
		Like like = new Like();
		
		like.setId(1);
		
		assertEquals(like.getId(), 1);
	}
	
	@Test
	public void test_getters_setters_likePostId() {
		
		Like like = new Like();
		
		like.setPostId(1);
		
		assertEquals(like.getPostId(), 1);
	}
	
	@Test
	public void test_getters_setters_likeUsername() {
		
		Like like = new Like();
		
		like.setUsername("testuser");
		
		assertEquals(like.getUsername(), "testuser");
	}
}
