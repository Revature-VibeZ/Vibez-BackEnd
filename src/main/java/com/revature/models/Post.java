package com.revature.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Transient;

import lombok.Data;

@Entity
@Table(name="posts")
@Data
public class Post {
	//a post is the same thing as a comment, which is the same thing as a reply, all 3 are 1 entity.
	//parent id will be null in the case of a top level post
	//some fields are nullable, for example a comment or nested comment/reply may not have an image attached
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private String uuid;
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")	
	private Date creationDate;
	
	//parent id is null for top level posts, otherwise if parent id is not null it's a comment or nested comment
	//using Integer instead of int because parentId is null at the top level. Java compiler will unbox/convert back down to a primitive if needed.
	@Column(name="parent_id")
	private Integer parentId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User author;
	
	@OneToMany
	@JoinColumn(name="post_id")
	private List<Like> likes;

	@OneToMany
	@JoinColumn(name="parent_id")
	private List<Post> comments;
	
	@Transient
	@Size(max=1000)
	private String image;
}
