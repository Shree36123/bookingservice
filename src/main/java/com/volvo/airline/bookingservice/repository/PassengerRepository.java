package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}