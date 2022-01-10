package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import com.revature.DAOs.UserDao;
import com.revature.models.User;
import com.revature.services.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserDao ud;
	
	@Autowired
	private UserService us;
	
	@Test
	public void createUserWithParams() {
		User u = new User();
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		us.createUser(u);
		
		List<User> users = ud.findAll();
		User user = users.get(13);
		assertEquals(user.getFirstName(), "Joe");

	}
	
	

}
