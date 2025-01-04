package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.CheckIn;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository extends JpaRepository<CheckIn, Long> {
}