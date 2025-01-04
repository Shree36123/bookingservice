package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.BookingHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Long> {
}