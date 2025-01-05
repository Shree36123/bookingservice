package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.BookingHistory;
import com.volvo.airline.bookingservice.service.BookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookingHistories")
public class BookingHistoryController {

    @Autowired
    private BookingHistoryService bookingHistoryService;

    @PostMapping
    public ResponseEntity<BookingHistory> createBookingHistory(@RequestBody BookingHistory bookingHistory) {
        BookingHistory savedBookingHistory = bookingHistoryService.saveBookingHistory(bookingHistory);
        return ResponseEntity.ok(savedBookingHistory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingHistory> getBookingHistoryById(@PathVariable Long id) {
        BookingHistory bookingHistory = bookingHistoryService.getBookingHistoryById(id);
        return ResponseEntity.ok(bookingHistory);
    }

    @GetMapping
    public ResponseEntity<List<BookingHistory>> getAllBookingHistories() {
        List<BookingHistory> bookingHistories = bookingHistoryService.getAllBookingHistories();
        return ResponseEntity.ok(bookingHistories);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingHistory(@PathVariable Long id) {
        bookingHistoryService.deleteBookingHistory(id);
        return ResponseEntity.noContent().build();
    }
}