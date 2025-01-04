package com.volvo.airline.bookingservice.model;

import com.volvo.airline.bookingservice.model.enums.Gender;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails extends BaseEntity {
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private Gender gender;
    private String userName;
    private String password;
}
