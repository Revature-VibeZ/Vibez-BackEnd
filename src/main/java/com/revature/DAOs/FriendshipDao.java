package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Friendship;
import com.revature.models.User;

@Repository
public interface FriendshipDao extends JpaRepository<Friendship, Integer> {
	List<Friendship> findFirstAndSecond (User user);
	boolean friendshipExists (User first, User second);
	void acceptRequest (Friendship request);
	void denyRequest (Friendship request);
	Friendship makeRequest (Friendship request);
	List<Friendship> getRequestByUser (User user);
	

}
