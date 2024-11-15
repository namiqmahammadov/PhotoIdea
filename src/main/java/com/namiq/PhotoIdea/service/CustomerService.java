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
		Optional<Customer> existingCustomer = customerRepository.findByEmail(customer.getEmail());
		if (existingCustomer.isPresent()) {
			throw new DuplicateCustomerException("Bu email ilə müştəri artıq mövcuddur: " + customer.getEmail());
		}
		return customerRepository.save(customer);
	}

	public Customer findById(Integer id) {
		Customer object = null;
		Optional<Customer> finded = customerRepository.findById(id);

		if (finded.isPresent()) {
			object = finded.get();

			return object;
		}
//				else {
//					throw new UnauthorizedException("Access denied");
//				}

		else {
			throw new CustomerNotFoundException("Musteri kodu tapılmadı :" + id);
		}

	}

	public void edit(Customer customer) {
		customerRepository.save(customer);
		
	}

	public void deleteById(Integer id)  {
		boolean customerExists = customerRepository.findById(id).isPresent();
	
		Customer customer = customerRepository.findById(id).orElse(null);
		if (customerExists) {
			
			customerRepository.deleteById(id);	
		
//			else {
//				throw new UnauthorizedException("Access denied");
//			}
		} else {
			throw new CustomerNotFoundException("Musteri kodu tapılmadı :" + id);
		}

	}
}
