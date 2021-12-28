package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "replys")
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int replyId;
	@Length(min=3)
	@Column(nullable=false, unique=true)
	private String reply;
	@Column(name="timestamp", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String replyDate;
	
	//One to Many from User on reply
	@ManyToOne
	@JoinColumn(name = "commentId")
	private Comment comment;
	
	//One to Many from Comment on reply
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
	
	//Transient for username of reply author
	@Transient
	private String replyAuthor;

	public Reply() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reply(int replyId, @Length(min = 3) String reply, String replyDate, Comment comment, User user,
			String replyAuthor) {
		super();
		this.replyId = replyId;
		this.reply = reply;
		this.replyDate = replyDate;
		this.comment = comment;
		this.user = user;
		this.replyAuthor = replyAuthor;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReplyAuthor() {
		return replyAuthor;
	}

	public void setReplyAuthor(String replyAuthor) {
		this.replyAuthor = replyAuthor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((reply == null) ? 0 : reply.hashCode());
		result = prime * result + ((replyAuthor == null) ? 0 : replyAuthor.hashCode());
		result = prime * result + ((replyDate == null) ? 0 : replyDate.hashCode());
		result = prime * result + replyId;
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
		Reply other = (Reply) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (reply == null) {
			if (other.reply != null)
				return false;
		} else if (!reply.equals(other.reply))
			return false;
		if (replyAuthor == null) {
			if (other.replyAuthor != null)
				return false;
		} else if (!replyAuthor.equals(other.replyAuthor))
			return false;
		if (replyDate == null) {
			if (other.replyDate != null)
				return false;
		} else if (!replyDate.equals(other.replyDate))
			return false;
		if (replyId != other.replyId)
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
		return "Reply [replyId=" + replyId + ", reply=" + reply + ", replyDate=" + replyDate + ", comment=" + comment
				+ ", user=" + user + ", replyAuthor=" + replyAuthor + "]";
	}
	
	

}
