package com.namiq.PhotoIdea.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namiq.PhotoIdea.entitiy.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
	// Əlavə sorğular lazımdırsa burada yaradıla bilər
}
