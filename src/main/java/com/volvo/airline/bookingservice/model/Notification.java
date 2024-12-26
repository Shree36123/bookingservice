package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
public class Notification extends BaseEntity {
    @ToString.Exclude
    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY, cascade = jakarta.persistence.CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserDetails user;
    @ManyToOne
    @JoinColumn(name = "booking_record_id")
    private BookingRecord bookingRecord;
    private NotificationType notificationType;
}
