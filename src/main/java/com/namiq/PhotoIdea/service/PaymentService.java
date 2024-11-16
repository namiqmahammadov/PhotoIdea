package com.namiq.PhotoIdea.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.namiq.PhotoIdea.entitiy.Payment;
import com.namiq.PhotoIdea.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Yeni ödəniş əlavə et
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Bütün ödənişləri gətir
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Müştərinin ödənişlərini gətir
    public List<Payment> getPaymentsByCustomerId(Long customerId) {
        return paymentRepository.findByCustomerId(customerId);
    }

    // Sessiya üçün ödənişləri gətir
    public List<Payment> getPaymentsBySessionId(Long sessionId) {
        return paymentRepository.findBySessionId(sessionId);
    }

    // Ödəniş statusuna görə ödənişləri gətir
    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByPaymentStatus(status);
    }
}
