package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.revature.models.Like;
import com.revature.services.LikeService;

@RestController
@RequestMapping("/likes")
@CrossOrigin("*")
public class LikeController {
	
	private LikeService ls;
	 
	@Autowired public LikeController(LikeService ls) { 
	this.ls = ls; 
	} 
		
	@PostMapping
	public ResponseEntity<Like> create(@RequestParam(name="postId") int postId, @RequestParam(name="username") String username){
		Like res = ls.createLike(username, postId);
		if(res != (null)){
			return new ResponseEntity<Like>(res, HttpStatus.CREATED);
		};
		return new ResponseEntity<Like>(HttpStatus.BAD_REQUEST);
	}
	 
	@GetMapping
    // req params: filter by post id, right now returns all likes
	public List<Like> getByPostId(@RequestParam(name="postId") int postId) {
		return ls.getLikesByPostId(postId);
	}

	@DeleteMapping
	public ResponseEntity<Integer> delete(@RequestParam(name="postId") int postId, @RequestParam(name="username") String username){
		int id = 0;
		System.out.println(id);
		List<Like> likes = ls.getLikesByPostId(postId);
		System.out.println(id);
		for(Like like : likes) {
			System.out.println(id);
			if(like.getUsername().equals(username)) {
				id = like.getId();
				System.out.println(id);
				ls.delete(id);
			}
		}
		System.out.println(id);
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
}