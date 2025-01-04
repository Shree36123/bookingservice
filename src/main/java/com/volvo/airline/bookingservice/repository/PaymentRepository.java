package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}