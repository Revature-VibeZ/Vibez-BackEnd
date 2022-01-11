package com.revature.vibez;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.revature.models.User;

@SpringBootTest
public class UserTests {

	@Test
	public void test_setters_and_getters_id() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getId() == 1);
		
	}
	
	@Test
	public void test_setters_and_getters_firstName() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getFirstName() == "Joe");
		
	}
	
	@Test
	public void test_setters_and_getters_lasttName() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getLastName() == "Yooser");
		
	}
	
	@Test
	public void test_setters_and_getters_email() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getEmail() == "testmail@testing.com");
		
	}
	
	@Test
	public void test_setters_and_getters_password() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getPassword() == "joepass");
		
	}
	
	@Test
	public void test_setters_and_getters_username() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getUsername() == "joeusername");
		
	}
	
	@Test
	public void test_setters_and_getters_bio() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getBio() == "bio");
		
	}
	
	@Test
	public void test_setters_and_getters_profile_pic() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getProfilePicture() == "profile pic");
		
	}
	
	@Test
	public void test_setters_and_getters_profile_uuid() {
		User u = new User();
		
		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
		u.setBio("bio");
		u.setId(1);
		u.setProfilePicture("profile pic");
		u.setUuid("test uuid");
		
		assertTrue(u.getUuid() == "test uuid");
		
	}

}
