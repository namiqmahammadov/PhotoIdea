package com.namiq.PhotoIdea.request;

import org.springframework.beans.factory.annotation.Autowired;

import com.namiq.PhotoIdea.entitiy.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
	@Autowired
	private Customer customer;
	
	
    @Id
    private String email; // Email adresini unikal ID kimi istifadə edirik
    private String password; // Şifrə
    private Boolean enabled; // İstifadəçinin aktiv olub olmadığını göstərir
    
    
    public User(String email,String password) {
    	this.email=customer.getEmail();
    	this.password=customer.getPassword();
    }
  
}
