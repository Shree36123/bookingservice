package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Passenger extends BaseEntity {
    private String email;
    private String firstName;
    private Gender gender;
    private String lastName;
    private Long mobileNumber;
    @ManyToOne
    @JoinColumn(name = "booking_record_id")
    private BookingRecord bookingRecord;
}
