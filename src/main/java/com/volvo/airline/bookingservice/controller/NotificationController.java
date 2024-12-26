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
    public ResponseEntity<List<Notification>> getNotifications() {
        return new ResponseEntity<>(notificationService.getNotification(), HttpStatus.OK);
    }

    @PostMapping("save")
    public Notification saveNotification(@RequestBody NotificationDAO notification) {
        return notificationService.addNotification(notification);
    }

    @PutMapping("update")
    public Notification updateNotification(@RequestBody NotificationDAO notification) {
        return notificationService.updateNotification(notification);
    }

    @DeleteMapping("delete")
    public String deleteNotification(@RequestParam("id") Long id) {
        return notificationService.deleteNotification(id);
    }
}
