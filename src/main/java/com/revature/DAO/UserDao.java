package com.revature.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	User save(User user);
	User findById(int id);
	ArrayList<User> findAll();
}