package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
//This model allows us to construct Like entities for manipulation
@Entity
@Table(name="likes")
@Data
public class Like {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	@Column(name="username", nullable=false)
	private String username;
	@Column(name = "post_id", nullable=false)
	private int postId;
	
}
