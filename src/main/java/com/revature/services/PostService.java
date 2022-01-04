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

	public List<Post> getTopLevelPosts() {
		return pd.findByParentIdIsNull();
	}
	
	public void saveImage(MultipartFile file) {
		S3Service s3 = new S3Service();
		try {
			System.out.print(s3.upload(file));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
