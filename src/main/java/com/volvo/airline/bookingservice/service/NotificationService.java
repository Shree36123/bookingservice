package com.volvo.airline.bookingservice.service;

import com.volvo.airline.bookingservice.mapper.NotificationMapper;
import com.volvo.airline.bookingservice.model.BookingRecord;
import com.volvo.airline.bookingservice.model.Notification;
import com.volvo.airline.bookingservice.model.UserDetails;
import com.volvo.airline.bookingservice.model.dao.NotificationDAO;
import com.volvo.airline.bookingservice.repository.BookingRecordRepo;
import com.volvo.airline.bookingservice.repository.NotificationRepo;
import com.volvo.airline.bookingservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class NotificationService {
    private final NotificationRepo notificationRepo;
    private final UserRepository userRepository;
    private final BookingRecordRepo bookingRecordRepository;

    public NotificationService(NotificationRepo notificationRepo,
                               UserRepository userRepository,
                               BookingRecordRepo bookingRecordRepository) {
        this.notificationRepo = notificationRepo;
        this.userRepository = userRepository;
        this.bookingRecordRepository = bookingRecordRepository;
    }

    public List<NotificationDAO> getNotification() {
        return NotificationMapper.mapToListOfNotification(notificationRepo.findAll());
    }

    public NotificationDAO addNotification(NotificationDAO notificationDAO) {
        if (Objects.nonNull(notificationDAO)) {
            UserDetails userDetails = userRepository.findById(notificationDAO.getUserId()).orElseThrow(() -> new RuntimeException("Unable to find the user"));
            BookingRecord bookingRecord = bookingRecordRepository.findById(notificationDAO.getBookingId()).orElseThrow(() -> new RuntimeException("Unable to find booking id"));
            Notification notification = new Notification();
            notification.setNotificationType(notificationDAO.getNotificationType());
            notification.setUser(userDetails);
            notification.setBookingRecord(bookingRecord);
            notification.setCreatedTime(LocalDateTime.now());
            return NotificationMapper.mapToNotificationDAO(notificationRepo.save(notification));
        }
        return null;
    }

    public NotificationDAO updateNotification(NotificationDAO notificationDAO) {
        Notification existing = new Notification();
        Notification notification = new Notification();
        if (Objects.nonNull(notificationDAO)) {
            UserDetails userDetails = userRepository.findById(notificationDAO.getUserId()).orElseThrow(() -> new RuntimeException("Unable to find the user"));
            BookingRecord bookingRecord = bookingRecordRepository.findById(notificationDAO.getBookingId()).orElseThrow(() -> new RuntimeException("Unable to find booking id"));
            if (Objects.nonNull(notificationDAO.getNotificationType()))
                notification.setNotificationType(notificationDAO.getNotificationType());
            notification.setUser(userDetails);
            notification.setBookingRecord(bookingRecord);
            notification.setUpdatedTime(LocalDateTime.now());
            return NotificationMapper.mapToNotificationDAO(notificationRepo.save(notificationRepo.findById(notification.getId()).orElseThrow(() -> new RuntimeException("Notification already existed"))));
        } else {
            return null;
        }
    }

    public String deleteNotification(Long id) {
        Notification existing = new Notification();
        if (Objects.nonNull(id)) {
            existing = notificationRepo.findById(id).orElseThrow(() -> new RuntimeException("Notification already existed"));
            notificationRepo.deleteById(existing.getId());
            return "Record deleted successfully";
        }
        return "Unable to delete the record";
    }
}
