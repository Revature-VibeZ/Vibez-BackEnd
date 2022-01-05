package com.revature.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.DAOs.FriendshipDao;
import com.revature.DAOs.UserDao;
import com.revature.models.Friendship;
import com.revature.models.User;

@Service
public class FriendshipService {
	
	private FriendshipDao fd;
	private UserDao ud;
	
	@Autowired
	public FriendshipService (FriendshipDao fd, UserDao ud) {
		super();
		this.fd = fd;
		this.ud = ud;
	}
	
	

	public void acceptRequest(Friendship request) {
		User first = ud.getById(request.getFirstUserId());
		User second = ud.getById(request.getSecondUserId());
		
		List<User> firstFriend = first.getFriends();
		List<User> secondFriend = second.getFriends();
		
		firstFriend.add(second);
		secondFriend.add(first);
		
		first.setFriends(firstFriend);
		second.setFriends(secondFriend);
		
		ud.save(first);
		ud.save(second);
		
		fd.delete(request);
	}
	
	public void denyRequest(Friendship request) {
		fd.delete(request);
	}
	
	public List<Friendship> getRequestByUser (User user){
		return fd.findFirstAndSecond(user);
	}
	
	public Friendship makeRequest(Friendship request) {
		User first = ud.getById(request.getFirstUserId());
		User second = ud.getById(request.getSecondUserId());
		if(!fd.friendshipExists(first, second) && !fd.friendshipExists(second, first)) {
			return fd.save(request);
		}else {
			return null;
		}
	}
	
	

}
