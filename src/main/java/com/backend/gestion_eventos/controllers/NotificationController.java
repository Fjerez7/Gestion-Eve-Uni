package com.backend.gestion_eventos.controllers;

import com.backend.gestion_eventos.models.Notification;
import com.backend.gestion_eventos.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/notifications")
@RequiredArgsConstructor
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> saveNotification(@RequestBody Notification notification) {
        try {
            Notification newNotification = notificationService.saveNotification(notification);
            return ResponseEntity.ok(newNotification);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable Integer id) {
        try {
            notificationService.deleteNotification(id);
            return ResponseEntity.ok().body("Notification deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Error deleting notification");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable Integer id) {
        try {
            Notification notification = notificationService.getNotificationById(id);
            return ResponseEntity.ok(notification);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications() {
        try {
            return ResponseEntity.ok(notificationService.getNotifications());
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
