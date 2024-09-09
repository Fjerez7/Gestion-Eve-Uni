package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Event;
import com.backend.gestion_eventos.repositories.EventRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventRepository eventRepository;

    @Transactional
    public Event save(Event event) {
        Event newEvent = Event.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .location(event.getLocation())
                .startHour(event.getStartHour())
                .endHour(event.getEndHour())
                .creationDate(LocalDateTime.now())
                .image("default.jpg")
                .category(event.getCategory())
                .program(event.getProgram())
                .build();
        return eventRepository.save(newEvent);
    }

    public Event findById(Integer id) {
        return eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Transactional
    public Optional<Event> update(Integer id, Event event) {
       return eventRepository.findById(id).map(e -> {
           e.setTitle(event.getTitle() == null ? e.getTitle() : event.getTitle());
           e.setDescription(event.getDescription() == null ? e.getDescription() : event.getDescription());
           e.setLocation(event.getLocation() == null ? e.getLocation() : event.getLocation());
           e.setStartHour(event.getStartHour() == null ? e.getStartHour() : event.getStartHour());
           e.setEndHour(event.getEndHour() == null ? e.getEndHour() : event.getEndHour());
           e.setProgram(event.getProgram() == null ? e.getProgram() : event.getProgram());
           return eventRepository.save(e);
       });
    }

    @Transactional
    public void delete(Integer id) {
        eventRepository.deleteById(id);
    }

}
