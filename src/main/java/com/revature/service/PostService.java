package com.revature.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.revature.DAO.PostDao;
import com.revature.DAO.UserDao;
import com.revature.models.Comment;
import com.revature.models.Post;
import com.revature.models.Reply;
import com.revature.models.User;

@Service
public class PostService {
	
	private PostDao pd;
	private UserDao ud;
	private S3Service s3;
	
	public PostService(PostDao pd, UserDao ud) {
		this.pd = pd;
		this.ud = ud;	
		
	}	
	
	public boolean createPost(String postContent, MultipartFile  file) {
//		User user = new User();
//		user.setUserId(1);
//		user.setFirstName("22442");
//		user.setLastName("last");
//		user.setUsername("username");
//		user.setPassword("password");
//		user.setEmail("email");
//		ud.save(user);
//
//		Post post = new Post();	
//		post.setTitle("title");		
//		post.setContent(postContent);
//		post.setUser(user);
//		pd.save(post);
		S3Service s3 = new S3Service();
		try {
			System.out.print(s3.upload(file));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
	}
	

}
