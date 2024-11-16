package com.namiq.PhotoIdea.entitiy;

import java.math.BigDecimal;
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
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Ödənişin unikal identifikatoru

    private Long customerId; // Müştərinin identifikatoru

    private Long sessionId; // Sessiyanın identifikatoru

    @Column(nullable = false)
    private BigDecimal amount; // Ödənilən məbləğ

    @CreationTimestamp
    private LocalDateTime paymentDate; // Ödənişin tarixi

    @Column(nullable = false)
    private String paymentStatus; 
}


