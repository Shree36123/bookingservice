package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.Notification;
import com.volvo.airline.bookingservice.model.dao.NotificationDAO;
import com.volvo.airline.bookingservice.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notification/api/")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("get")
    public ResponseEntity<List<NotificationDAO>> getNotifications() {
        return new ResponseEntity<>(notificationService.getNotification(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<NotificationDAO> saveNotification(@RequestBody NotificationDAO notification) {
        return new ResponseEntity<>(notificationService.addNotification(notification), HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<NotificationDAO> updateNotification(@RequestBody NotificationDAO notification) {
        return new ResponseEntity<>(notificationService.updateNotification(notification), HttpStatus.CREATED);
    }

    @DeleteMapping("delete")
    public String deleteNotification(@RequestParam("id") Long id) {
        return notificationService.deleteNotification(id);
    }
}
