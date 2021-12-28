package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.UserRepository;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

@Service
public class UserService {
	
	private UserRepository ur;

	@Autowired
	public UserService(UserRepository ur) {
		this.ur = ur;
	}

	public List<User> getAllUsers() {
		return ur.findAll();
	}

	public List<User> getUserByUsername(String username) {
		return ur.findUserByUsername(username);
	}
	
	public User getUserById(int id) {
		return ur.findById(id).orElseThrow(UserNotFoundException::new);
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
