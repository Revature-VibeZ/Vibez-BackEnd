package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
// import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.Valid;

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
		
	// @PostMapping
	// public ResponseEntity<Boolean> post(@RequestParam(name="post") String post){
	// 	ps.createPost(post);
	// 	return null;
	// }
	@PostMapping
	public ResponseEntity<Post> create(@Valid @RequestBody Post p, @RequestParam(name = "username") String username){
		return new ResponseEntity<>(ps.createPost(p, username), HttpStatus.CREATED);
	}
	@RequestMapping("/new")
	@PostMapping
	public ResponseEntity post( @RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam(name="content") String post,
			@RequestParam(name="username") String username
			){
		Post p = new Post();
		p.setContent(post);
		ps.createPostWithFile(p, username, file);
		return null;
	}
	
	@GetMapping
	public List<Post> get() {
		return ps.getTopLevelPosts();
	}
}