package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}