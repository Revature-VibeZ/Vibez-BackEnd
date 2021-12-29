package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.revature.models.Like;
import com.revature.service.LikeService;

@RestController
@RequestMapping("/likes")
@CrossOrigin("*")
public class LikeController {
	
	private LikeService ls;
	 
	@Autowired public LikeController(LikeService ls) { 
	this.ls = ls; 
	} 
		
	@PostMapping
	public ResponseEntity<Boolean> create(@RequestParam(name="post") String post){
		ls.createPost(post);
		return null;
	}
	
	@GetMapping
    // req params: filter by post id, right now returns all likes
	public List<Like> getByPostId(@RequestParam(name="postId") int postId) {
		return ls.getLikesByPostId(postId);
	}
}