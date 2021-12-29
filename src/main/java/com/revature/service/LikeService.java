package com.revature.service;

import java.util.List;
// import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

// import javax.persistence.Column;

// import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Service;

import com.revature.DAO.LikeDao;
// import com.revature.DAO.PostDao;
// import com.revature.DAO.UserDao;
import com.revature.models.Like;
// import com.revature.models.Comment;
// import com.revature.models.Post;
// import com.revature.models.Reply;
// import com.revature.models.User;

@Service
public class LikeService {
	
	private LikeDao ld;
	
    @Autowired
	public LikeService(LikeDao ld) {
		this.ld = ld;
	}	
	
	public boolean createPost(String postContent) {
		return true;
	}

	public List<Like> getAllPosts() {
		return ld.findAll();
	}

    public List<Like> getLikesByPostId(int postId) {
        return ld.findByPostId(postId);
    }
}
