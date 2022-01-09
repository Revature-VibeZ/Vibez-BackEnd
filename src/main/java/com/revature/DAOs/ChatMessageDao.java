package com.revature.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.ChatMessage;

@Repository
public interface ChatMessageDao extends JpaRepository<ChatMessage, Integer> {
}