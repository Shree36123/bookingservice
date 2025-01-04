package com.volvo.airline.bookingservice.model.dao;

import com.volvo.airline.bookingservice.model.BaseEntity;
import com.volvo.airline.bookingservice.model.enums.Origin;
import com.volvo.airline.bookingservice.model.enums.Status;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecordDAO {
    private Long id;
    private LocalDateTime bookingDate;
    private String destination;
    private Origin origin;
    private Status status;
}

