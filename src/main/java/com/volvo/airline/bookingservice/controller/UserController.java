package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.User;
import com.volvo.airline.bookingservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user/api/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("get")
    public ResponseEntity<List<User>> getUser() {
        return new ResponseEntity<>(userService.getUser(), HttpStatus.OK);
    }

    @RequestMapping("save")
    public User saveUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping("update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping("delete")
    public String deleteUser(@RequestParam("id") Long id) {
        return userService.deleteUser(id);
    }
}
