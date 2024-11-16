package com.namiq.PhotoIdea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.entitiy.User;
import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.repository.CustomerRepository;

@Service
public class UserService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Giriş əməliyyatı
	public User login(String email, String password) {
		Customer customer = customerRepository.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException("İstifadəçi tapılmadı: " + email));

		if (!passwordEncoder.matches(password, customer.getPassword())) {
			throw new CustomerNotFoundException("Yanlış parol.");
		}

		return new User(customer); // Müvəffəqiyyətli giriş zamanı `User` obyektini qaytarır
	}
}
