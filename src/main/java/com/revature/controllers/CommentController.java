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

import com.revature.models.Comment;
import com.revature.services.CommentService;
@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {
	
	private CommentService cs;
		
		
		@Autowired
		public CommentController(CommentService cs) {
			this.cs = cs;
		}
		
		@GetMapping
		public List<Comment> getAllComments(@RequestParam(name="postID", required = false)Integer postID ){
			if(postID != null) {
				return cs.getCommentsByPostID(postID);
			}
			
			return cs.getAllComments();
		}
		
		@PostMapping
		public ResponseEntity<String> createComment(@RequestBody Comment comment) {
			cs.createComment(comment);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}


				
		@PutMapping("/{id}")
		public ResponseEntity<String> updateComment(@PathVariable(name = "id") int id, @RequestBody Comment comment) {
			cs.updateComment(id, comment);
			return new ResponseEntity<>( HttpStatus.OK);

		}
}
