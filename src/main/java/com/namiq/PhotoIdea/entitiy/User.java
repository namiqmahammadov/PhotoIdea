package com.namiq.PhotoIdea.entitiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private String username; // Customer email
	private String password; // Customer password

	public User(Customer customer) {
		this.username = customer.getEmail();
		this.password = customer.getPassword();
	}
}

