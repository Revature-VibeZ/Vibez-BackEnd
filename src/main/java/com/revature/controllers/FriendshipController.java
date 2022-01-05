package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Friendship;
import com.revature.services.FriendshipService;
import com.revature.services.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/friends")
@CrossOrigin(exposedHeaders = "Authorization")
public class FriendshipController {

	private FriendshipService fs;
	private UserService us;

	@Autowired
	public FriendshipController(FriendshipService fs, UserService us) {
		super();
		this.fs = fs;
		this.us = us;
	}

//	// All friend requests sent to the current user logged in
//	@GetMapping("/myrequests")
//	public ResponseEntity<List<Friendship>> getRequests(@RequestHeader("Authorization") String token) {
//		return new ResponseEntity<>(fs.getRequestsByUser(us.getUserById(token)), HttpStatus.OK);
//	}

	// Make a new friend request
	@PostMapping("/newrequest")
	public ResponseEntity<Friendship> newRequest(@RequestHeader("Authorization") String token, 
	@RequestBody Friendship request) {
		return new ResponseEntity<>(fs.makeRequest(request), HttpStatus.CREATED);
	}

	// Request is used to accept a given friend request for given user
	@PutMapping("/accept")
	public ResponseEntity<Void> acceptRequest(@RequestHeader("Authorization") String token,
	@RequestBody Friendship request) {
		fs.acceptRequest(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// Request is used to deny a friend request
	@PutMapping("/deny")
	public ResponseEntity<Void> denyRequest(@RequestHeader("Authorization") String token,
	@RequestBody Friendship request) {
		fs.denyRequest(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
