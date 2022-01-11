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

import com.revature.controllers.UserController;
import com.revature.models.User;
import com.revature.services.UserService;

@SpringBootTest
public class UserControllerTests {
	
	@Autowired
	public UserService us;
	
	@Autowired
	public UserController uc;
	
	@Test
	public void gets_user_if_id_given(){
		int id = 1;
		User u = uc.getUserById(id);
		assertNotNull(u);
	}
	
	@Test
	public void gets_all_users_if_username_null() {
		String username = null;
		String email = null;
		List<User> users = uc.getAllUsers(username, email);	
		int size = users.size();
		assertEquals(size, 13);	
	}
	
	// @SuppressWarnings("unchecked")
	// @Test
	// public void creates_user_if_user_given() {
	// 	User u = new User();

	// 	u.setFirstName("Joe");
	// 	u.setLastName("Yooser");
	// 	u.setEmail("testmail@testing.com");
	// 	u.setPassword("joepass");
	// 	u.setUsername("joeusername");
		
	// 	// uc.createUser(u);
		
	// 	String email = null;
	// 	String username = null;
	// 	List<User> users = us.getAllUsers();
	// 	int size = users.size();
	// 	assertEquals(size, 14);	
	// }
}
