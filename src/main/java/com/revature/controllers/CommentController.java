package com.revature.controllers;

import com.revature.models.Post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {

	@PostMapping
	// request param get parent id, whether it's a top level post or nested comment
	// they're both still considered posts with an id
	public ResponseEntity<String> createComment(@RequestBody Post comment) {

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// allows a user to update a comment.
	@PutMapping("/{id}")
	public ResponseEntity<String> updateComment(@PathVariable(name = "id") int id, @RequestBody Post comment) {

		return new ResponseEntity<>(HttpStatus.OK);

	}
}