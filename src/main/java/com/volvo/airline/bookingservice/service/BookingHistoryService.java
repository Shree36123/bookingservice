package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.BookingHistory;
import com.volvo.airline.bookingservice.repository.BookingHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingHistoryService {

    @Autowired
    private BookingHistoryRepository bookingHistoryRepository;


    public BookingHistory saveBookingHistory(BookingHistory bookingHistory) {
        return bookingHistoryRepository.save(bookingHistory);
    }


    public BookingHistory getBookingHistoryById(Long id) {
        Optional<BookingHistory> bookingHistory = bookingHistoryRepository.findById(id);
        return bookingHistory.orElse(null);
    }


    public List<BookingHistory> getAllBookingHistories() {
        return bookingHistoryRepository.findAll();
    }

    public void deleteBookingHistory(Long id) {
        bookingHistoryRepository.deleteById(id);
    }
}