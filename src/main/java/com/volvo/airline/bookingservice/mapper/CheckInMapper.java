package com.volvo.airline.bookingservice.mapper;

import com.volvo.airline.bookingservice.model.BookingRecord;
import com.volvo.airline.bookingservice.model.dao.CheckInDto;
import com.volvo.airline.bookingservice.model.CheckIn;

import java.util.List;
import java.util.Objects;

public class CheckInMapper {
    public static CheckInDto toDTO(CheckIn checkIn) {
        if (checkIn == null) {
            return null;
        }

        return CheckInDto.builder()
                .id(checkIn.getId())
                .seatNumber(checkIn.getSeatNumber())
                .gateNumber(checkIn.getGateNumber())
                .bookingRecordId(checkIn.getBookingRecord() != null ? checkIn.getBookingRecord().getId() : null)
                .build();
    }

    public static List<CheckInDto> checkInDtos(List<CheckIn> checkIns) {
        return checkIns.stream()
                .map(CheckInMapper::toDTO)
                .toList();
    }

    public static CheckIn toEntity(CheckInDto checkInDTO) {
        if (checkInDTO == null) {
            return null;
        }

        CheckIn checkIn = new CheckIn();
        checkIn.setId(checkInDTO.getId());
        checkIn.setSeatNumber(checkInDTO.getSeatNumber());
        checkIn.setGateNumber(checkInDTO.getGateNumber());

        if (checkInDTO.getBookingRecordId() != null) {
            BookingRecord bookingRecord = new BookingRecord();
            bookingRecord.setId(checkInDTO.getBookingRecordId());
            checkIn.setBookingRecord(bookingRecord);
        }
        return checkIn;
    }

    public static CheckIn toEntity(CheckInDto checkInDTO, CheckIn checkIn) {
        if (checkInDTO == null) {
            return null;
        } else if (Objects.isNull(checkIn)) {
            return toEntity(checkInDTO);
        }
        checkIn.setId(checkInDTO.getId());
        checkIn.setSeatNumber(Objects.nonNull(checkInDTO.getSeatNumber()) ? checkInDTO.getSeatNumber() : checkIn.getSeatNumber());
        checkIn.setGateNumber(Objects.nonNull(checkInDTO.getGateNumber()) ? checkInDTO.getGateNumber() : checkIn.getGateNumber());

        if (checkInDTO.getBookingRecordId() != null) {
            BookingRecord bookingRecord = new BookingRecord();
            bookingRecord.setId(checkInDTO.getBookingRecordId());
            checkIn.setBookingRecord(bookingRecord);
        }
        return checkIn;
    }
}
