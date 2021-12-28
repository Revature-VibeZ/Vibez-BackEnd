package com.revature.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")

public class PostController {
private PostService ps;
	
	
	@Autowired
	public PostController(PostService ps) {
		this.ps = ps;
	}
	
	@GetMapping
	public List<Post> getAllPosts(@RequestParam(name = "userID", required = false)Integer userID ){
		if(userID != null) {
			return ps.getPostsByUser(userID);
		}
		return ps.getAllPosts();
	}
	
	@PostMapping
	public ResponseEntity<String> createPost(@RequestBody Post post) {
		ps.createPost(post);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}


			
	@PutMapping("/{id}")
	public ResponseEntity<String> updatePost(@PathVariable(name = "id") int id, @RequestBody Post post) {
		ps.updatePost(id, post);
		return new ResponseEntity<>( HttpStatus.OK);

	}
}
