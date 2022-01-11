package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.revature.DAOs.LikeDao;

import com.revature.models.Like;

@Service
public class LikeService {

	private LikeDao ld;

	@Autowired
	public LikeService(LikeDao ld) {
		this.ld = ld;
	}
 //Creates a like for a post.
	public Like createLike(String username, int postId) {
		Like like = new Like();
		like.setUsername(username);
		like.setPostId(postId);

		List<Like> theseLikes = ld.findByPostId(postId);
		boolean liked = false;

		for(Like like1 : theseLikes) {
			if (username.equals(like1.getUsername())) liked = true;
		};

		if (liked == false) return ld.save(like);
		return null;
	}
//Gets all the likes
	public List<Like> getAllLikes() {
		return ld.findAll();
	}
//Gets likes for a specific post
	public List<Like> getLikesByPostId(int postId) {
		return ld.findByPostId(postId);
	}
//Removes a like.
    public int delete(int id) {
		ld.deleteById(id);
		return id;
    }
}
