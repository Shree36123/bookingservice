package com.volvo.airline.bookingservice.mapper;

import com.volvo.airline.bookingservice.model.Notification;
import com.volvo.airline.bookingservice.model.dao.NotificationDAO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotificationMapper {
    public static Notification mapToNotification(NotificationDAO notificationDAO, Notification notification) {
        if (Objects.nonNull(notificationDAO)) {
            BeanUtils.copyProperties(notificationDAO, notification);
            return notification;
        }
        return notification;
    }

    public static NotificationDAO mapToNotificationDAO(Notification notification) {
        NotificationDAO notificationDAO = new NotificationDAO();
        if (Objects.nonNull(notification)) {
            BeanUtils.copyProperties(notification, notificationDAO);
            return notificationDAO;
        }
        return notificationDAO;
    }

    public static List<NotificationDAO> mapToListOfNotification(List<Notification> notificationList) {
        if (!notificationList.isEmpty()) {
            return notificationList.stream().map(NotificationMapper::mapToNotificationDAO).toList();
        }
        return new ArrayList<>();
    }
}