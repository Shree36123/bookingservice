package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.mapper.BookingRecordMapper;
import com.volvo.airline.bookingservice.model.BookingRecord;
import com.volvo.airline.bookingservice.model.dao.BookingRecordDAO;
import com.volvo.airline.bookingservice.repository.BookingRecordRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookingRecordService {
    private final BookingRecordRepo bookingRecordRepo;

    public BookingRecordService(BookingRecordRepo bookingRecordRepo) {
        this.bookingRecordRepo = bookingRecordRepo;
    }

    public List<BookingRecordDAO> getAllBookingRecords() {
        return BookingRecordMapper.mapToListOfBookingRecordDAO(bookingRecordRepo.findAll());
    }

    public BookingRecordDAO addBookingRecord(BookingRecordDAO bookingRecordDAO) {
        return BookingRecordMapper.mapToBookingRecordDAO(bookingRecordRepo.save(BookingRecordMapper.mapToBookingRecord(bookingRecordDAO, null)));
    }

    public BookingRecordDAO updateBookingRecord(BookingRecordDAO bookingRecordDAO) {
        if (Objects.nonNull(bookingRecordDAO)) {
            BookingRecord bookingRecord1 = BookingRecordMapper.mapToBookingRecord(bookingRecordDAO, bookingRecordRepo.findById(bookingRecordDAO.getId()).orElseThrow(() -> new RuntimeException("Booking record not found")));
            return BookingRecordMapper.mapToBookingRecordDAO(
                    bookingRecordRepo.save(
                            BookingRecordMapper.mapToBookingRecord(bookingRecordDAO, bookingRecord1)));
        }
        throw new RuntimeException("Booking record not found");
    }

    public String deleteBookingRecord(Long id) {
        if (bookingRecordRepo.existsById(id)) {
            bookingRecordRepo.deleteById(id);
            return "Record deleted successfully";
        }
        return "Unable to delete the record";
    }
}