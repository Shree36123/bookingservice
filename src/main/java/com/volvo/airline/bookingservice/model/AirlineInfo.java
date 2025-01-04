package com.volvo.airline.bookingservice.model;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AirlineInfo extends BaseEntity {
    String airlineName;
}
