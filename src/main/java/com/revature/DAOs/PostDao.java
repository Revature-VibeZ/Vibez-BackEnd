package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {
	List<Post> findByParentIdIsNull();
}