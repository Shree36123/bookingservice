package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.UserDetails;
import com.volvo.airline.bookingservice.model.dao.UserDAO;
import com.volvo.airline.bookingservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("get")
    public ResponseEntity<List<UserDetails>> getUser() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public UserDetails saveUser(@RequestBody UserDAO user) {
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDetails> updateUser(@RequestBody UserDAO user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        return userService.deleteUser(id);
    }
}
