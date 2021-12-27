package com.revature.models;

public class Reply {
	
	private int id;
	private String reply;
	private String replyDate;
	
	//One to Many from User on reply
	
	//One to Many from Comment on reply
	
	
	//Transient for username of reply author
	private String replyAuthor;

}
