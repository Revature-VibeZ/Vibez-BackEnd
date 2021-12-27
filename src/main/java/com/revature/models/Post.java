package com.revature.models;

import org.springframework.stereotype.Component;

@Component
public class Post {
	
	private int id;
	private String title;
	private String content;
	private String image;
	private String creationDate;
	
	//Many to Many between Post and User on likes

}
