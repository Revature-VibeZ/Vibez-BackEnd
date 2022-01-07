package com.revature.services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Post;
import com.revature.models.User;
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

	@Transactional(propagation = Propagation.REQUIRED)
	public void createUser(User u) {
		ud.save(u);
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

	public void resetPassword(String username, String password) {
		List<User> users = ud.findUserByUsername(username);	
		System.out.println(users.toString());
		User currentUser = users.get(0);
		currentUser.setPassword(password);
		ud.save(currentUser);

	}
	
	public String uploadProfileImage(String username, MultipartFile file) {
		List<User> users = ud.findUserByUsername(username);	
		System.out.println(users.toString());
		User user = users.get(0);
		try {
			saveImage(user, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ud.save(user);		
		return user.getProfilePicture();		
	}
	
	public void saveImage(User u, MultipartFile file) throws IOException {
		S3Service s3 = new S3Service();
		try {
			u.setUuid(s3.upload(file));		
			u.setProfilePicture(s3.getSignedUrl(u.getUuid()));
			// String filename = (s3.upload(file));
			// to get the actual link
			//System.out.println(s3.getSignedUrl(filename));			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
