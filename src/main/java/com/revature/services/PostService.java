package com.revature.services;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.revature.DAOs.PostDao;
import com.revature.DAOs.UserDao;
import com.revature.models.Post;
import com.revature.models.User;

@Service
public class PostService {
	private PostDao pd;
	private UserDao ud;
	private S3Service s3;
	 
	public PostService(PostDao pd, UserDao ud, S3Service s3) {
		this.pd = pd;
		this.ud = ud;
		this.s3 = s3;
	}	
	//Creates a Post
	public Post createPost(Post p, String username) {
		saveAuthor(p, username);
		p.setCreationDate(new Date());		
		return pd.save(p);
	}
	//Creates a Post that has a picture attached
	public Post createPostWithFile(Post p, String username, MultipartFile file) throws IOException {
		saveAuthor(p, username);
		p.setCreationDate(new Date());
		if (file != null) saveImage(p, file);
		if (p.getUuid()!= null) {
			p.setImage(s3.getSignedUrl(p.getUuid()));
		}
		return pd.save(p);
	}
//Gets a post that is not a comment.
	public List<Post> getTopLevelPosts() throws IOException {	
		List<Post> listPosts = pd.findByParentIdIsNull();
		for (Post post : listPosts) {			
			if (post.getAuthor().getUuid() != null) {
				post.getAuthor().setProfilePicture(s3.getSignedUrl(post.getAuthor().getUuid()));
			}
			//uuid is a unique identifier for the file
			if (post.getUuid()!= null) {
				post.setImage(s3.getSignedUrl(post.getUuid()));
			}
		}		
		listPosts.sort(Comparator.comparing(Post::getId));		
		return listPosts;
	}
	//Saves the image for a Post.
	public void saveImage(Post p, MultipartFile file) throws IOException {
		try {
			p.setUuid(s3.upload(file));		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveAuthor(Post p, String username) {
		List<User> users = ud.findByUsername(username);
		User u = users.get(0);
		p.setAuthor(u);
	}
}
