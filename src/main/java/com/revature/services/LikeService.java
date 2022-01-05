package com.revature.services;

import java.util.ArrayList;
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

	public void createLike(String username, int postId) {
		Like like = new Like();
		like.setUsername(username);
		like.setPostId(postId);
		
		List<Like> theseLikes = ld.findByPostId(postId);
		boolean liked = false;
		
		for (int i = 0; i < theseLikes.size(); i++) {
			Like thisLike = theseLikes.get(i);
			if (username == thisLike.getUsername()){
				liked = true;
			}
		}
		
		if (liked = false) {		
		ld.save(like);
		}
	}

	public List<Like> getAllLikes() {
		return ld.findAll();
	}

	public List<Like> getLikesByPostId(int postId) {
		return ld.findByPostId(postId);
	}
}
