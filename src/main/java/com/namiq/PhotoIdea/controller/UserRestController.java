package com.namiq.PhotoIdea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.namiq.PhotoIdea.entitiy.User;
import com.namiq.PhotoIdea.service.CustomerService;
import com.namiq.PhotoIdea.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserRestController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	// Giriş
	@PostMapping("/login")
	public User loginUser(@RequestParam String email, @RequestParam String password) {
		return userService.login(email, password);
	}

	// Parolu yenilə
	@PutMapping("/password")
	public void updatePassword(@RequestParam String email, @RequestParam String newPassword) {
		customerService.updatePassword(email, newPassword);
	}

}
