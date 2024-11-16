package com.namiq.PhotoIdea.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.exception.DuplicateCustomerException;
import com.namiq.PhotoIdea.repository.CustomerRepository;



@Service
public class CustomerService {
	   @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    // Yeni müştəri əlavə et
	    public Customer addCustomer(Customer customer) {
	        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
	            throw new DuplicateCustomerException("Bu email ilə müştəri artıq mövcuddur: " + customer.getEmail());
	        }

	        customer.setPassword(passwordEncoder.encode(customer.getPassword())); // Parolu şifrələyirik
	        return customerRepository.save(customer);
	    }

	    // Müştərinin parolunu yenilə
	    public void updatePassword(String email, String newPassword) {
	        Customer customer = customerRepository.findByEmail(email)
	                .orElseThrow(() -> new CustomerNotFoundException("Müştəri tapılmadı: " + email));

	        customer.setPassword(passwordEncoder.encode(newPassword)); // Yeni parolu şifrələyirik
	        customerRepository.save(customer);
	    }

	    // Müştərini email vasitəsilə tap
	    public Customer findByEmail(String email) {
	        return customerRepository.findByEmail(email)
	                .orElseThrow(() -> new CustomerNotFoundException("Müştəri tapılmadı: " + email));
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
