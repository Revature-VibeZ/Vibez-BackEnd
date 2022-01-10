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
	private S3Service s3;
	 
	public PostService(PostDao pd, UserDao ud, S3Service s3) {
		this.pd = pd;
		this.ud = ud;
		this.s3 = s3;
	}	
	
	public Post createPost(Post p, String username) {
		saveAuthor(p, username);
		p.setCreationDate(new Date());		
		return pd.save(p);
	}
	
	public Post createPostWithFile(Post p, String username, MultipartFile file) throws IOException {
		saveAuthor(p, username);
		p.setCreationDate(new Date());
		if (file != null) saveImage(p, file);
		if (p.getUuid()!= null) {
			p.setImage(s3.getSignedUrl(p.getUuid()));
		}
		return pd.save(p);
	}

	public List<Post> getTopLevelPosts() throws IOException {		
		for (Post post : pd.findByParentIdIsNull()) {
			//uuid is a unique identifier for the file
			if (post.getUuid()!= null) {
				post.setImage(s3.getSignedUrl(post.getUuid()));
				pd.save(post);
			}
		}
		return pd.findByParentIdIsNull();
	}
	
	public void saveImage(Post p, MultipartFile file) throws IOException {
		try {
			p.setUuid(s3.upload(file));	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveAuthor(Post p, String username) {
		List<User> users = ud.findUserByUsername(username);
		User u = users.get(0);
		p.setAuthor(u);
	}
}
