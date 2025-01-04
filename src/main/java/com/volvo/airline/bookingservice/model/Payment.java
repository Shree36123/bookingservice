package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.PaymentStatus;
import com.volvo.airline.bookingservice.model.enums.PaymentType;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Payment extends BaseEntity {
    private PaymentType paymentType;
    private PaymentStatus paymentStatus;
    private LocalDateTime transaction;
}
