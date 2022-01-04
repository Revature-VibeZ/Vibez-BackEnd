package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Comment;
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
	public ResponseEntity post( @RequestPart(value = "file", required = false) MultipartFile file,
			@RequestParam(name="post") String post,
			@RequestParam(name="post") String username
			){
		ps.createPost(post, file);		
		
		
		return null;
	}
	
}