package com.namiq.PhotoIdea.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.namiq.PhotoIdea.entitiy.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	// Müəyyən bir müştərinin ödənişlərini tapmaq
	List<Payment> findByCustomerId(Long customerId);

	// Müəyyən bir sessiya üçün edilən ödənişləri tapmaq
	List<Payment> findBySessionId(Long sessionId);

	// Müəyyən bir status üzrə ödənişləri tapmaq
	List<Payment> findByPaymentStatus(String status);
}
