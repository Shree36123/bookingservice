package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRecordRepo extends JpaRepository<BookingRecord,Long> {
}
