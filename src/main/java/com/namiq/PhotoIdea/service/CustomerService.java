package com.namiq.PhotoIdea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.Exception.DuplicateCustomerException;
import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.repository.CustomerRepository;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public Customer addCustomer(Customer customer) {
		Optional<Customer>existingCustomer =customerRepository.findByEmail(customer.getEmail());
		if(existingCustomer.isPresent()) {
			throw new DuplicateCustomerException("Bu email ilə müştəri artıq mövcuddur: " + customer.getEmail());
		}
		return customerRepository.save(customer);
	}
	
	
		
}


