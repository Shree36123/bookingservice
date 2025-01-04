package com.volvo.airline.bookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class BookingHistory extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "booking_record_id")
    private BookingRecord bookingRecord;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
}
