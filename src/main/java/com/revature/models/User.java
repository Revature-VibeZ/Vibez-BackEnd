package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Length(min=3)
	@Column(nullable=false)
	private String firstName;
	@Length(min=3)
	@Column(nullable=false)
	private String lastName;
	@Length(min=3)
	@Column(nullable=false, unique=true)
	private String username;
	@Length(min=3)
	@Column(nullable=false)
	private String password;
	@Length(min=3)
	@Column(nullable=false, unique=true)
	private String email;
	private String bio;
	private String profilePicture;
}

//comment as requested by kevin
