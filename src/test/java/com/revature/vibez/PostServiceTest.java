package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Post;
import com.revature.models.User;
import com.revature.services.PostService;
import com.revature.services.UserService;

@SpringBootTest
public class PostServiceTest {
	
	// @Autowired
	// private PostDao pd;
	
	@Autowired
	private PostService ps;
	
	@Autowired
	private UserService us;
	
	@Test
	public void createdPostHasUserAttached() {
		Post p = new Post();
		p.setTitle("Joe");
		p.setContent("Yooser");
		p.setUuid("testmail@testing.com");
//		p.setUsername("username1");		
		ps.createPost(p, "username1");		
		List<User> users = us.getAllUsers();
		User user = users.get(0);
		p.setAuthor(user);
		assertEquals(user.getUsername(), "username1");

	}
	
	
//	@Test
//	public void canSaveImageToPost() {
//		Post p = new Post();
//		p.setTitle("Joe");
//		p.setContent("Yooser");
//		p.setUuid("testmail@testing.com");
//		p.setUsername("username1");
//		ps.createPostWithFile();
//	
//
//	}

}
