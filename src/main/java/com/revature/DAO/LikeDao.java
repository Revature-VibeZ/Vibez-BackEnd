package com.revature.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Like;

@Repository
public interface LikeDao extends JpaRepository<Like, Integer> {
    //save not needed it's already defined in crud repository
    List<Like> findByPostId(int postId);
}