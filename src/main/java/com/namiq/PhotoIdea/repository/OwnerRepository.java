package com.namiq.PhotoIdea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namiq.PhotoIdea.entitiy.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
	// E-poçt ilə obyekt sahibini tapmaq
	Owner findByEmail(String email);
}
