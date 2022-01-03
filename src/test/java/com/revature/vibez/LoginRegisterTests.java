package com.revature.vibez;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import com.revature.models.User;
import com.revature.repositories.UserDao;
import com.revature.services.AuthService;
import com.revature.services.UserService;

@SpringBootTest
class LoginRegisterTests {

	
	@Autowired
	private UserService us;
	
	@Autowired
	private AuthService as;
	
	@MockBean
	private UserDao ud;
	
	@BeforeAll
	public void setUpLogin() {
	    User hello = new User();
	    hello.setUsername("hello");

	    Mockito.when(ud.findByUsername(hello.getUsername()))
	      .thenReturn(hello);
	}
	
	@Test
	public void whenValidName_thenUserShouldBeFound() {
	    String username = "hello";
	    UserDetails found = as.loadUserByUsername(username);
	 
	     assertEquals(found.getUsername(), username);
	 }
}
