package com.volvo.airline.bookingservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Flight extends BaseEntity {
    private String destination;
    private String flightNumber;
    private String origin;
    private LocalTime time;
    private LocalDate date;
    private LocalDateTime flightTime;
    private Integer numberOfSeats;
    @ManyToOne
    @JoinColumn(name = "airline_id")
    private AirlineInfo airlineId;

}
