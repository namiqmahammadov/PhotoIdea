package com.namiq.PhotoIdea.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.namiq.PhotoIdea.entitiy.Customer;
import com.namiq.PhotoIdea.exception.MyValidationException;
import com.namiq.PhotoIdea.service.CustomerService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // Müştəri əlavə et
    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer, BindingResult br) {
        if (br.hasErrors()) {
            throw new MyValidationException(br);
        }
        return customerService.addCustomer(customer);
    }

    // Bütün müştəriləri göstər
    @GetMapping
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    // İD üzrə müştərini göstər
    @GetMapping("/{id}")
    public Customer findById(@PathVariable Integer id) {
        return customerService.findById(id);
    }

    // Müştərini yenilə
    @PutMapping("/{id}")
    public Customer edit(@PathVariable Integer id, @RequestBody Customer customer) {
        customer.setId(id);  // Müştəri İD-sini yeniləyir
        return customerService.edit(customer);
    }

    // Müştərini sil
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        customerService.deleteById(id);
    }
}
