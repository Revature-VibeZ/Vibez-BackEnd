package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentId;
	@Column(nullable=false)
	private String comment;
//	@Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String commentDate;
	
	//One to Many from User on comment
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	//One to Many from Post on comment
	@ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
	
	@OneToMany(mappedBy="comment")
	 private List<Reply> reply;
	
	//Transient column for Username to display who commented
	@Transient
	private String commentAuthor;
	
	//Transient column for the postId being commented on
	@Transient
	private int postId;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentId, String comment, String commentDate, User user, Post post, List<Reply> reply,
			String commentAuthor, int postId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.commentDate = commentDate;
		this.user = user;
		this.post = post;
		this.reply = reply;
		this.commentAuthor = commentAuthor;
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public List<Reply> getReply() {
		return reply;
	}

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	public String getCommentAuthor() {
		return commentAuthor;
	}

	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((commentAuthor == null) ? 0 : commentAuthor.hashCode());
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + commentId;
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + postId;
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (commentAuthor == null) {
			if (other.commentAuthor != null)
				return false;
		} else if (!commentAuthor.equals(other.commentAuthor))
			return false;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentId != other.commentId)
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (postId != other.postId)
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", commentDate=" + commentDate + ", user="
				+ user + ", post=" + post + ", reply=" + reply + ", commentAuthor=" + commentAuthor + ", postId="
				+ postId + "]";
	} 

}
