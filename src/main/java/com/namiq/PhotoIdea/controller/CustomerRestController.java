package com.namiq.PhotoIdea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.exception.MyValidationException;
import com.namiq.PhotoIdea.repository.CustomerRepository;
import com.namiq.PhotoIdea.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/customers")

public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping
	public Customer addCustomer( @Valid @RequestBody Customer customer,BindingResult br) {
		if(br.hasErrors()) {
			throw new  MyValidationException(br);
		}
		
		customer.setId(null);
		return customerService.addCustomer(customer);
	}
	@GetMapping
	public List<Customer> findAll(){
		return customerRepository.findAll();
		
	}
	

}
