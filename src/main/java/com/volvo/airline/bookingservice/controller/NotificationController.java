package com.volvo.airline.bookingservice.controller;

import com.volvo.airline.bookingservice.model.Notification;
import com.volvo.airline.bookingservice.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("notification/api/")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @RequestMapping("get")
    public ResponseEntity<List<Notification>> getNotifications() {
        return new ResponseEntity<>(notificationService.getNotification(), HttpStatus.OK);
    }

    @RequestMapping("save")
    public Notification saveNotification(@RequestBody Notification notification) {
        return notificationService.addNotification(notification);
    }

    @RequestMapping("update")
    public Notification updateNotification(@RequestBody Notification notification) {
        return notificationService.updateNotification(notification);
    }

    @RequestMapping("delete")
    public String deleteNotification(@RequestParam("id") Long id) {
        return notificationService.deleteNotification(id);
    }
}
