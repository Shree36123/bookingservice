package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FareRepository extends JpaRepository<Fare, Long> {
}