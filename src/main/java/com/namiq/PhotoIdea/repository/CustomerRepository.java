package com.namiq.PhotoIdea.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.namiq.PhotoIdea.entitiy.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Optional<Customer> findByEmail(String email);

}
