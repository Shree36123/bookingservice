package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.Origin;
import com.volvo.airline.bookingservice.model.enums.Status;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingRecord extends BaseEntity{
    private LocalDateTime bookingDate;
    private String destination;
    private Origin origin;
    private Status status;
}
