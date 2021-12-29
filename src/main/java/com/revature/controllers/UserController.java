package com.revature.controllers;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.revature.models.User;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")

public class UserController {




	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User user) {			
		return new ResponseEntity<>(HttpStatus.CREATED);
	}



	@PutMapping("/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {
		
		return new ResponseEntity<>( HttpStatus.OK);

	}


}