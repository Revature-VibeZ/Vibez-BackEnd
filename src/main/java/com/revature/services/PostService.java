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
	
	public Post createPost(Post p, String username) {
		List<User> users = ud.findUserByUsername(username);
		User user = users.get(0);
		int userId = user.getId();
		p.setAuthorId(userId);
		p.setCreationDate(new Date());		
		return pd.save(p);
	}
	
	public Post createPostWithFile(Post p, String username, MultipartFile file) {
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

	public List<Post> getTopLevelPosts() {		
		S3Service s3 = new S3Service();
		for (Post post : pd.findByParentIdIsNull()) {
			if (post.getUuid()!= null) {
				post.setImage(s3.getSignedUrl(post.getUuid()));
				pd.save(post);
			}
		}
		return pd.findByParentIdIsNull();
	}
	
	public void saveImage(Post p, MultipartFile file) {
		S3Service s3 = new S3Service();
		try {
			String filename = (s3.upload(file));
			p.setUuid(s3.upload(file));
			// to get the actual link
//			System.out.println(s3.getSignedUrl(filename));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
