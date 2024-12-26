package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.mapper.UserMapper;
import com.volvo.airline.bookingservice.model.UserDetails;
import com.volvo.airline.bookingservice.model.dao.UserDAO;
import com.volvo.airline.bookingservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails createUser(UserDAO userDAO) {
        if (Objects.isNull(userDAO)) {
            throw new RuntimeException("User element can't be null/n Enter the user details");
        }
        UserDetails userDetails = UserMapper.mapToUserDetails(userDAO, new UserDetails());
        userDetails.setCreatedTime(LocalDateTime.now());
        userDetails.setVersion(1);
        return userRepository.save(userDetails);
    }

    public UserDetails updateUser(UserDAO userDAO) {
        if (Objects.isNull(userDAO)) {
            throw new RuntimeException("User element can't be null/n Enter the user details");
        }
        UserDetails existingUser = userRepository.findById(userDAO.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUpdatedTime(LocalDateTime.now());
        existingUser.setVersion(existingUser.getVersion() + 1);
        UserDetails user = UserMapper.mapToUserDetails(userDAO, existingUser);
        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("User id can't be null/n Enter the user id");
        }
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return userRepository.findById(id).isPresent() ? "User not deleted" : "User deleted";
    }

    public List<UserDetails> getUser() {
        return userRepository.findAll();
    }
}
