package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.model.Notification;
import com.volvo.airline.bookingservice.repository.NotificationRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
public class NotificationService {
    private final NotificationRepo notificationRepo;

    public NotificationService(NotificationRepo notificationRepo) {
        this.notificationRepo = notificationRepo;
    }

    public List<Notification> getNotification() {
        return notificationRepo.findAll();
    }

    public Notification addNotification(Notification notification) {
        if (Objects.nonNull(notification)) {
            return notificationRepo.findById(notification.getId()).orElseThrow(() -> new RuntimeException("Notification already existed"));
        }
        return null;
    }

    public Notification updateNotification(Notification notification) {
        Notification existing;
        if (Objects.nonNull(notification)) {
            existing = notificationRepo.findById(notification.getId()).orElseThrow(() -> new RuntimeException("Notification already existed"));
        }
        existing = notification;
        return notificationRepo.save(existing);
    }

    public String deleteNotification(Long id) {
        Notification existing = null;
        if (Objects.nonNull(id)) {
            existing = notificationRepo.findById(id).orElseThrow(() -> new RuntimeException("Notification already existed"));
            notificationRepo.deleteById(existing.getId());
            return "Record deleted successfully";
        }
        return "Unable to delete the record";
    }
}
