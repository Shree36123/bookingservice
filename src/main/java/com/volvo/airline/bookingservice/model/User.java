package com.volvo.airline.bookingservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private Gender gender;
    private String userName;
    private String password;
}
