package com.revature.controllers;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	private UserService us;

	@Autowired
	public UserController(UserService us) {
		this.us = us;
	}
	//Gets all Users
	@GetMapping
	public List<User> getAllUsers(@RequestParam(name = "username", required = false) String username,
			@RequestParam(name = "email", required = false) String email) {
		if (username != null) return us.getUserByUsername(username);
		if (email != null) return us.getUserByEmail(email);
		return us.getAllUsers();
	}
	//Allows for creation of a new user
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) {
		us.createUser(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	//Allows for the password to be reset.
	@PutMapping("/reset")
	public ResponseEntity<String> resetPassword(@RequestParam String username, @RequestParam String password) {
		us.resetPassword(username, password);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	//Changing User's profile image
	@PutMapping
	public ResponseEntity<User> post(@RequestPart(value = "file", required = false) MultipartFile file,
			@RequestPart(value = "username", required = true) String username) throws IOException {
		try {
			User updatedUser = us.uploadProfileImage(username, file);
			return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	//Gets a user by their User ID
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name = "id") int id) {
		return us.getUserById(id);
	}
}