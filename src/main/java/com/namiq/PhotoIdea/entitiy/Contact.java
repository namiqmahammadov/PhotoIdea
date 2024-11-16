package com.namiq.PhotoIdea.entitiy;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Əlaqə qeydin unikallığı

	@Column(nullable = false)
	private String name; // Müştərinin adı

	@Column(nullable = false, unique = true)
	private String email; // Müştərinin e-poçt ünvanı

	@Column(nullable = false, length = 500)
	private String message; // Müştərinin göndərdiyi mesaj

	@CreationTimestamp
	private LocalDateTime createdAt; // Mesajın göndərilmə tarixi

}
