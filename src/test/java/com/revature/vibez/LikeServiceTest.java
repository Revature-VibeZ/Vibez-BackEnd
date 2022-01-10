package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Like;
import com.revature.services.LikeService;

@SpringBootTest
public class LikeServiceTest {
	
	@Autowired
	public LikeService ls;
	
	@Test
	public void creates_like_if_username_and_post_id_given() {
		String username = "testuser";
		int postId = 1;
		
		Like like = ls.createLike(username, postId);
		
		assertNotNull(like);
	}
	
	@Test
	public void can_get_all_likes() {
		
		List<Like> likes = ls.getAllLikes();
		
		assertEquals(likes.size(), 3);
	}
	
	@Test
	public void gets_all_likes_by_postId() {
		
		List<Like> likes1 = ls.getLikesByPostId(1);
		
		assertEquals(likes1.size(), 3);
	}
	
	@Test 
	public void can_delete_by_post_id() {
		
		int id = 1;
		
		ls.delete(1);
		
		List<Like> likes1 = ls.getLikesByPostId(1);
		
		assertEquals(likes1.size(), 2);
	}
	
}
