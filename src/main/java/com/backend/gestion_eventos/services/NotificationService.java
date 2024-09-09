package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Event;
import com.backend.gestion_eventos.models.Notification;
import com.backend.gestion_eventos.models.User;
import com.backend.gestion_eventos.repositories.EventRepository;
import com.backend.gestion_eventos.repositories.NotificationRepository;
import com.backend.gestion_eventos.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final EventRepository  eventRepository;
    private final UserRepository userRepository;


    @Transactional
    public Notification saveNotification(Notification notification) {
        Event event = eventRepository.findById(notification.getEvent().getId()).orElseThrow();
        User user = userRepository.findById(notification.getUser().getId()).orElseThrow();
        Notification newNotification = Notification.builder()
                .message(notification.getMessage())
                .date(notification.getDate())
                .event(event)
                .user(user)
                .build();
        return notificationRepository.save(newNotification);
    }
    @Transactional
    public void deleteNotification(Integer id) {
        notificationRepository.deleteById(id);
    }

    public Notification getNotificationById(Integer id) {
        return notificationRepository.findById(id).orElseThrow();
    }

    public List<Notification> getNotifications() {
        return notificationRepository.findAll();
    }


}
