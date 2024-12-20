package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.User;
import com.volvo.airline.bookingservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (Objects.isNull(user)) {
            throw new RuntimeException("User element can't be null/n Enter the user details");
        }
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        if (Objects.isNull(user)) {
            throw new RuntimeException("User element can't be null/n Enter the user details");
        }
        User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        existingUser = user;
        return userRepository.save(existingUser);
    }

    public String deleteUser(Long id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException("User id can't be null/n Enter the user id");
        }
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return userRepository.findById(id).isPresent() ? "User not deleted" : "User deleted";
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }
}
