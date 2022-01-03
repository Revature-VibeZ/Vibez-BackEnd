package com.revature.services;

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
	
	public boolean createPost(String postContent) {
		User user = new User();
		// user.setUserId(1);
		user.setFirstName("22442");
		user.setLastName("last");
		user.setUsername("username");
		user.setPassword("password");
		user.setEmail("email");
		ud.save(user);

		Post post = new Post();	
		post.setTitle("title");		
		post.setContent(postContent);
		// post.setUser(user);
		pd.save(post);
		return true;
	}

	public List<Post> getTopLevelPosts() {
		return pd.findByParentIdIsNull();
	}
}
