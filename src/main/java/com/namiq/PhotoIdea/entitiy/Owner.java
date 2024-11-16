package com.namiq.PhotoIdea.entitiy;

import java.time.LocalDateTime;

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
@Table(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Owner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String role; // Məsələn, "photo expert", "manager"

	@CreationTimestamp
	private LocalDateTime createdAt;
}
