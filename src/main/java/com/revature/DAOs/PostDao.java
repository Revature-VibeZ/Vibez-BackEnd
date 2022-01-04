package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
	// Post save(Post post); not needed as crud repository already has it, avoids error message
	// List<Post> findByParentId(int id);
	List<Post> findByParentIdIsNull();
	
}