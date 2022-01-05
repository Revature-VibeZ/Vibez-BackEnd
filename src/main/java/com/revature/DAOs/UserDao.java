package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	List<User> findUserByUsername(String username);
	List<User> getFriends(int Id);

}