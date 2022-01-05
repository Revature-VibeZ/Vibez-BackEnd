package com.revature.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="friendships")
@Data
public class Friendship {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int friendshipId;
	@Column(name="first_user_id", nullable=false)
	private int firstUserId;
	@Column(name="second_user_id", nullable=false)
	private int secondUserId;
}
