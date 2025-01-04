package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.AirlineInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineInfoRepo extends JpaRepository<AirlineInfo, Long> {
}