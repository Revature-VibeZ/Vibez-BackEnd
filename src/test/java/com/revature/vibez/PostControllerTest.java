package com.revature.vibez;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

import com.revature.controllers.PostController;
import com.revature.models.Post;
import com.revature.services.PostService;


@SpringBootTest
public class PostControllerTest {
	
	@Autowired
	public PostService ps;
	
	@Autowired
	public PostController pc;
	
	

}
