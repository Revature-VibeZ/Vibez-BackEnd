package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	//uses one to many and many to one relationship
	//basically a join between user/post table on user_id, 
	//and then search for users with username == input username
	@EntityGraph(attributePaths = {"username"})
	public List<User> findByUsername(String username);
}