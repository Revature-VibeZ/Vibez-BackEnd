package com.revature.models;

public class Comment {
	
	private int id;
	private String comment;
	private String commentDate;
	
	
	//One to Many from User on comment
	
	//One to Many from Post on comment
	
	//Transient column for Username to display who commented
	private String commentAuthor;
	
	
	//Transient column for the postId being commented on
	private int postId; 
	

}
