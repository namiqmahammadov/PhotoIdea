package com.namiq.PhotoIdea.entitiy;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotEmpty(message = "bos qoymaq olmaz")
	@Size(min = 2,message = "minimum 2 simvol olmalidir")
	@Size(max= 15,message = "maxsimum 15 simvol olmalidir")
	private String firstname;
	@NotEmpty(message = "bos qoymaq olmaz")
	@Size(min = 2,message = "minimum 2 simvol olmalidir")
	@Size(max= 20,message = "maxsimum 20 simvol olmalidir")
	private String lastname;
	@NotEmpty(message = "Email can not empty")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", 
            message = "Invalid email format")
	private String email;
	@Pattern(regexp = "\\+994\\s?\\d{2}\\s?\\d{3}\\s?\\d{2}\\s?\\d{2}", message = "Telefon nömrəsi +994 XX XXX XX XX formatında olmalıdır")
	private String phoneNumber;
	private String password;
	@CreationTimestamp
	private LocalDateTime createdAt;
}
