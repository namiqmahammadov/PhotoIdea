package com.namiq.PhotoIdea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namiq.PhotoIdea.entitiy.Payment;
import com.namiq.PhotoIdea.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentRestController {

	@Autowired
	private PaymentService paymentService;

	// Yeni ödəniş əlavə et
	@PostMapping
	public ResponseEntity<Payment> addPayment(@RequestBody Payment payment) {
		return new ResponseEntity<>(paymentService.addPayment(payment), HttpStatus.CREATED);
	}

	// Bütün ödənişləri gətir
	@GetMapping
	public ResponseEntity<List<Payment>> getAllPayments() {
		return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
	}

	// Müştərinin ödənişlərini gətir
	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Payment>> getPaymentsByCustomerId(@PathVariable Long customerId) {
		return new ResponseEntity<>(paymentService.getPaymentsByCustomerId(customerId), HttpStatus.OK);
	}

	// Sessiya üçün ödənişləri gətir
	@GetMapping("/session/{sessionId}")
	public ResponseEntity<List<Payment>> getPaymentsBySessionId(@PathVariable Long sessionId) {
		return new ResponseEntity<>(paymentService.getPaymentsBySessionId(sessionId), HttpStatus.OK);
	}

	// Status üzrə ödənişləri gətir
	@GetMapping("/status/{status}")
	public ResponseEntity<List<Payment>> getPaymentsByStatus(@PathVariable String status) {
		return new ResponseEntity<>(paymentService.getPaymentsByStatus(status), HttpStatus.OK);
	}
}
