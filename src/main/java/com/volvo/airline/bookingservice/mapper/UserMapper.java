package com.volvo.airline.bookingservice.mapper;

import com.volvo.airline.bookingservice.model.UserDetails;
import com.volvo.airline.bookingservice.model.dao.UserDAO;

import java.util.Objects;

public class UserMapper {
    public static UserDetails mapToUserDetails(UserDAO userDAO, UserDetails userDetails) {
        if (Objects.nonNull(userDAO)) {
            if (!userDAO.getFirstName().isEmpty()) userDetails.setFirstName(userDAO.getFirstName());
            if (!userDAO.getLastName().isEmpty()) userDetails.setLastName(userDAO.getLastName());
            if (Objects.nonNull(userDAO.getGender())) userDetails.setGender(userDAO.getGender());
            if (Objects.nonNull(userDAO.getPhoneNumber())) userDetails.setPhoneNumber(userDAO.getPhoneNumber());
            if (!userDAO.getUserName().isEmpty()) userDetails.setUserName(userDAO.getUserName());
            return userDetails;
        } else {
            return userDetails;
        }
    }
}
