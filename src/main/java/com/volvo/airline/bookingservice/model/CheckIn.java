package com.volvo.airline.bookingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class CheckIn extends BaseEntity {
    private String seatNumber;
    private String gateNumber;
    @ManyToOne
    @JoinColumn(name = "booking_record_id")
    private BookingRecord bookingRecord;
}
