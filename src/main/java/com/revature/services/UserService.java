package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DAOs.UserDao;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@Service
public class UserService {
	
	private UserDao ud;

	@Autowired
	public UserService(UserDao ud) {
		this.ud = ud;
	}

	public List<User> getAllUsers() {
		return ud.findAll();
	}

	public List<User> getUserByUsername(String username) {
		return ud.findUserByUsername(username);
	}
	
	public User getUserById(int id) {
		return ud.findById(id).orElseThrow(UserNotFoundException::new);
	}
	

	public List<User> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public void createUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public void updateUser(int id, User user) {
		// TODO Auto-generated method stub
		
	}

}
