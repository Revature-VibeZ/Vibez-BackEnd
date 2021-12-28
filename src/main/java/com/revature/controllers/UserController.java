package com.revature.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {

	private UserService us;
	
	
	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	
	@GetMapping
	public List<User> getAllUsers(@RequestParam(name = "username", required = false)String username,@RequestParam(name = "id", required = false)Integer id, @RequestParam(name = "email", required = false)String email ){
		if(username != null) {
			return us.getUserByUsername(username);
		}
		if(id != null) {
			return us.getUserById(id);
		}
		if(email != null) {
			return us.getUserByEmail(email);
		}
		return us.getAllUsers();
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) {
		us.createUser(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


			
	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {
		us.updateUser(id, user);
		return new ResponseEntity<>( HttpStatus.OK);

	}
	
	
}
