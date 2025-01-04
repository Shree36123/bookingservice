package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.BookingRecord;
import com.volvo.airline.bookingservice.model.dao.BookingRecordDAO;
import com.volvo.airline.bookingservice.service.BookingRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking/api/")
public class BookingRecordController {
    private final BookingRecordService bookingRecordService;

    public BookingRecordController(BookingRecordService bookingRecordService) {
        this.bookingRecordService = bookingRecordService;
    }

    @GetMapping("get")
    public ResponseEntity<List<BookingRecordDAO>> getBookingRecords() {
        return new ResponseEntity<>(bookingRecordService.getAllBookingRecords(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<BookingRecordDAO> saveBookingRecord(@RequestBody BookingRecordDAO bookingRecordDAO) {
        return new ResponseEntity<>(bookingRecordService.addBookingRecord(bookingRecordDAO), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<BookingRecordDAO> updateBookingRecord(@RequestBody BookingRecordDAO bookingRecordDAO) {
        return new ResponseEntity<>(bookingRecordService.updateBookingRecord(bookingRecordDAO), HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteBookingRecord(@RequestParam("id") Long id) {
        return new ResponseEntity<>(bookingRecordService.deleteBookingRecord(id), HttpStatus.OK);
    }
}