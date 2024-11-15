package com.namiq.PhotoIdea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.exception.CustomerNotFoundException;
import com.namiq.PhotoIdea.exception.DuplicateCustomerException;
import com.namiq.PhotoIdea.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Müştəri əlavə et
    public Customer addCustomer(Customer customer) {
        if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new DuplicateCustomerException("Bu email ilə müştəri artıq mövcuddur: " + customer.getEmail());
        }
        return customerRepository.save(customer);
    }

    // İD üzrə müştəri tap
    public Customer findById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Müştəri tapılmadı: " + id));
    }

    // Müştərini yenilə
    public Customer edit(Customer customer) {
        if (!customerRepository.existsById(customer.getId())) {
            throw new CustomerNotFoundException("Müştəri tapılmadı: " + customer.getId());
        }
        return customerRepository.save(customer);
    }

    // İD üzrə müştəri sil
    public void deleteById(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException("Müştəri tapılmadı: " + id);
        }
        customerRepository.deleteById(id);
    }

    // Bütün müştəriləri çək
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
