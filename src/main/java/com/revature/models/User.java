package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Table(name = "users")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Length(min = 3)
	@Column(nullable = false)
	private String firstName;
	@Length(min = 3)
	@Column(nullable = false)
	private String lastName;
	@Length(min = 3)
	@Column(nullable = false, unique = true)
	private String username;
	@Length(min = 3)
	@Column(nullable = false)
	private String password;
	@Length(min = 3)
	@Column(nullable = false, unique = true)
	private String email;
	private String bio;

	//permanent aws image id
	private String uuid;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private List<Post> posts;
	
	//uuid used to generate temporary viewable aws image
	//expires after time set in s3 service getsignedurl method
	@Transient
	@Size(max = 1000)
	private String profilePicture;
}