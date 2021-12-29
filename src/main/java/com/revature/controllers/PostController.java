package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.revature.models.Post;
import com.revature.services.PostService;

@RestController
@RequestMapping("/posts")
@CrossOrigin("*")
public class PostController {
	
	private PostService ps;
	 
	@Autowired public PostController(PostService ps) { 
		this.ps = ps; 
	} 
		
	@PostMapping
	public ResponseEntity<Boolean> post(@RequestParam(name="post") String post){
		ps.createPost(post);
		return null;
	}
	
	@GetMapping
	public List<Post> get() {
		return ps.getTopLevelPosts();
	}
}