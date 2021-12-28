package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.revature.models.Post;
<<<<<<< HEAD
=======
import com.revature.models.Comment;
>>>>>>> 61dc58d0bfbc805a2d9bac268c53ba5b9c57487c
import com.revature.service.PostService;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
	
	private PostService ps;
	 
	@Autowired public PostController(PostService ps) { 
	this.ps = ps; 
	} 
		
	@PostMapping
	public ResponseEntity post(@RequestParam(name="post") String post){
		ps.createPost(post);		
		return null;
	}
<<<<<<< HEAD

=======
  
>>>>>>> 61dc58d0bfbc805a2d9bac268c53ba5b9c57487c
	@GetMapping
	public List<Post> get() {
		return ps.getAllPosts();
	}
<<<<<<< HEAD

=======
>>>>>>> 61dc58d0bfbc805a2d9bac268c53ba5b9c57487c
}