package com.volvo.airline.bookingservice.model.dao;

import com.volvo.airline.bookingservice.model.enums.NotificationType;
import jakarta.persistence.NamedEntityGraph;
import jdk.jfr.Name;
import lombok.*;
import org.hibernate.service.spi.InjectService;
import org.springframework.context.annotation.Bean;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDAO {
    private Long userId;
    private Long bookingId;
    private NotificationType notificationType;
}
