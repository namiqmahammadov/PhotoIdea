package com.namiq.PhotoIdea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namiq.PhotoIdea.entitiy.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
	List<Session> findByTitleContaining(String keyword);
}
