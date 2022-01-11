package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import javax.persistence.Column;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.Post;
import com.revature.models.User;

//private int id;
//private String title;
//private String content;
//private String uuid;
//private Date creationDate;
//private String username;
//private Integer parentId;

@SpringBootTest
public class PostTest {
	
	@Test
	public void test_getters_setters_postId() {
		Post p = new Post();
		p.setId(1);
		
		assertTrue(p.getId() == 1);
	}
	
	@Test
	public void test_getters_setters_title() {
		Post p = new Post();
		p.setTitle("test title");
		
		assertTrue(p.getTitle() == "test title");
	}
	
	@Test
	public void test_getters_setters_content() {
		Post p = new Post();
		p.setContent("test content");
		
		assertTrue(p.getContent().equals("test content"));
	}
	
	@Test
	public void test_getters_setters_post_uuid() {
		Post p = new Post();
		p.setUuid("uuid");
		
		assertTrue(p.getUuid() == "uuid");
	}
	
	@Test
	public void test_getters_setters_username() {
		Post p = new Post();
		User u = new User();
		u.setUsername("joeusername");
		p.setAuthor(u);		
		assertTrue(p.getAuthor().getUsername().equals("joeusername"));
	}
	
	@Test
	public void test_getters_setters_parentId() {
		Post p = new Post();
		p.setParentId(1);
		
		assertTrue(p.getParentId() == 1);
	}
}
