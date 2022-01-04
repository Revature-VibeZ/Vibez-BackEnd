package com.revature.services;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

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

	public List<Post> getTopLevelPosts() {
		return pd.findByParentIdIsNull();
	}
}
