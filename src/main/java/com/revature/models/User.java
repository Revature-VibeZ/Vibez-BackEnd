package com.revature.models;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
public class User {
	
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String bio;
	private String profilePicture;
	
	//One to Many relationship User to Post
	
	//Many to Many relationship Post & User on likes
	
	//Many to Many relationship User & User on friends
	

}
