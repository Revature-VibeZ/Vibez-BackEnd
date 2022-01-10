package com.revature.services;

import java.io.IOException;
import java.util.Date;
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
	
	public PostService(PostDao pd, UserDao ud) {
		this.pd = pd;
		this.ud = ud;		
	}	
	//Creates a Post
	public Post createPost(Post p, String username) {
		List<User> users = ud.findUserByUsername(username);
		User user = users.get(0);
		int userId = user.getId();
		p.setAuthorId(userId);
		p.setCreationDate(new Date());		
		return pd.save(p);
	}
	//Creates a Post that has a picture attached
	public Post createPostWithFile(Post p, String username, MultipartFile file) throws IOException {
		List<User> users = ud.findUserByUsername(username);	
		System.out.println(users.toString());
		User user = users.get(0);
		int userId = user.getId();
		p.setAuthorId(userId);
		p.setCreationDate(new Date());	
		if (file!= null) {
		saveImage(p, file);};
		return pd.save(p);
	
	}
//Gets a post that is not a comment.
	public List<Post> getTopLevelPosts() throws IOException {		
		S3Service s3 = new S3Service();
		for (Post post : pd.findByParentIdIsNull()) {
			//uuid is a unique identifier for the file
			if (post.getUuid()!= null) {
				post.setImage(s3.getSignedUrl(post.getUuid()));
				pd.save(post);
			}
		}
		return pd.findByParentIdIsNull();
	}
	//Saves the image for a Post.
	public void saveImage(Post p, MultipartFile file) throws IOException {
		S3Service s3 = new S3Service();
		try {
			p.setUuid(s3.upload(file));
				
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
