package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Table(name = "users")
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
	private String uuid;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Post> posts;
	
	@Transient
	@Size(max = 1000)
	private String profilePicture;
}