package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.Origin;
import com.volvo.airline.bookingservice.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecord extends BaseEntity {
    private LocalDateTime bookingDate;
    private String destination;
    private Origin origin;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Fare fare;
    @ManyToOne
    @JoinColumn(name = "flight_number")
    private String flightNumber;
    private LocalDate flightDate;
    private LocalTime flightTime;
}
