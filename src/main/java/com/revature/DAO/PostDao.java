package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Post;
import com.revature.models.User;

@Repository
public interface PostDao extends JpaRepository<Post, Integer> {

	Post save(Post post);

}