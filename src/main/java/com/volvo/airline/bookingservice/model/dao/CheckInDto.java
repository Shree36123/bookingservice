package com.volvo.airline.bookingservice.model.dao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CheckInDto {
    private Long id;
    private String seatNumber;
    private String gateNumber;
    private Long bookingRecordId;
}