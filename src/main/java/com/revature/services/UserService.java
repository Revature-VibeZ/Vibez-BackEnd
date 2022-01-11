package com.revature.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.revature.models.User;
import com.revature.DAOs.UserDao;
import com.revature.exceptions.UserNotFoundException;

@Service
public class UserService {

	private UserDao ud;

	@Autowired
	public UserService(UserDao ud) {
		this.ud = ud;
	}

	// Below fields allow us to manipulate User object on the Database.
	@Transactional(propagation = Propagation.REQUIRED)
	public void createUser(User u) {
		ud.save(u);
	}

	public List<User> getAllUsers() {
		return ud.findAll();
	}

	public List<User> getUserByUsername(String username) {
		List<User> users = ud.findByUsername(username);
		for (User u : users)
			u.setPassword(null);
		return users;
	}

	public User getUserById(int id) {
		return ud.findById(id).orElseThrow(UserNotFoundException::new);
	}

	public List<User> getUserByEmail(String email) {
		return null;
	}

	public void updateUser(User u) {		
		List<User> users = ud.findByUsername(u.getUsername());		
		User currentUser = users.get(0);		
		if(!u.getFirstName().isEmpty()) {
			currentUser.setFirstName(u.getFirstName());
		}
		if(!u.getLastName().isEmpty()) {
			currentUser.setLastName(u.getLastName());
		}
		if(!u.getEmail().isEmpty()) {
			currentUser.setEmail(u.getEmail());
		}
		if(!u.getPassword().isEmpty()) {
			currentUser.setPassword(u.getPassword());
		}
		if(!u.getBio().isEmpty()) {
			currentUser.setBio(u.getBio());
		}
		ud.save(currentUser);

	}

	public User uploadProfileImage(String username, MultipartFile file) {
		List<User> users = ud.findByUsername(username);
		User user = users.get(0);
		try {
			saveImage(user, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ud.save(user);
		return user;
	}

	public User saveImage(User u, MultipartFile file) throws IOException {
		S3Service s3 = new S3Service();
		try {
			u.setUuid(s3.upload(file));
			u.setProfilePicture(s3.getSignedUrl(u.getUuid()));
			return u;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
