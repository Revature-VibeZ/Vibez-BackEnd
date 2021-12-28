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

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {



		@PostMapping
		public ResponseEntity<String> createComment(@RequestBody Comment comment) {
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}



		@PutMapping("/{id}")
		public ResponseEntity<String> updateComment(@PathVariable(name = "id") int id, @RequestBody Comment comment) {
			
			return new ResponseEntity<>( HttpStatus.OK);

		}
}