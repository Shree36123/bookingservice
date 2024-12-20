package com.volvo.airline.bookingservice.repository;

import com.volvo.airline.bookingservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification, Long> {
}
