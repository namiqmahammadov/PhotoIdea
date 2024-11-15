package com.namiq.PhotoIdea.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namiq.PhotoIdea.request.User;

public interface UserRepository extends JpaRepository<User, String> {
Optional<User>findByEmail(String Email);
}
