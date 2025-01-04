package com.volvo.airline.bookingservice.mapper;

import com.volvo.airline.bookingservice.model.BookingRecord;
import com.volvo.airline.bookingservice.model.dao.BookingRecordDAO;
import io.micrometer.common.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class BookingRecordMapper {

    public static BookingRecordDAO mapToBookingRecordDAO(BookingRecord bookingRecord) {
        if (bookingRecord == null) {
            return null;
        }
        return BookingRecordDAO.builder()
                .id(bookingRecord.getId())
                .bookingDate(bookingRecord.getBookingDate())
                .destination(bookingRecord.getDestination())
                .origin(bookingRecord.getOrigin())
                .status(bookingRecord.getStatus())
                .build();
    }

    public static BookingRecord mapToBookingRecord(BookingRecordDAO bookingRecordDAO, BookingRecord bookingRecord1) {
        if (bookingRecordDAO == null) {
            return null;
        }
        BookingRecord bookingRecord = BookingRecord.builder()
                .bookingDate(Objects.nonNull(bookingRecordDAO.getBookingDate()) ? bookingRecordDAO.getBookingDate() : bookingRecord1.getBookingDate())
                .destination(!StringUtils.isEmpty(bookingRecordDAO.getDestination()) ? bookingRecordDAO.getDestination() : bookingRecord1.getDestination())
                .origin(Objects.nonNull(bookingRecordDAO.getOrigin()) ? bookingRecordDAO.getOrigin() : bookingRecord1.getOrigin())
                .status(Objects.nonNull(bookingRecordDAO.getStatus()) ? bookingRecordDAO.getStatus() : bookingRecord1.getStatus())
                .build();
        bookingRecord.setId(bookingRecordDAO.getId());
        return bookingRecord;
    }

    public static List<BookingRecordDAO> mapToListOfBookingRecordDAO(List<BookingRecord> bookingRecords) {
        return bookingRecords.stream()
                .map(BookingRecordMapper::mapToBookingRecordDAO)
                .toList();
    }
}