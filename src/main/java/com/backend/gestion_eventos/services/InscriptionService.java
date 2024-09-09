package com.backend.gestion_eventos.services;

import com.backend.gestion_eventos.models.Event;
import com.backend.gestion_eventos.models.Inscription;
import com.backend.gestion_eventos.models.User;
import com.backend.gestion_eventos.repositories.EventRepository;
import com.backend.gestion_eventos.repositories.InscriptionRepository;
import com.backend.gestion_eventos.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class InscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Transactional
    public Inscription saveInscription(Inscription inscription) {
        Event event = eventRepository.findById(inscription.getEvent().getId()).orElseThrow();
        User user = userRepository.findById(inscription.getUser().getId()).orElseThrow();
        Inscription newInscription = Inscription.builder()
                .event(event)
                .user(user)
                .date(LocalDateTime.now())
                .build();
        return inscriptionRepository.save(newInscription);
    }

    @Transactional
    public void deleteInscription(Integer id) {
        inscriptionRepository.deleteById(id);
    }

    public List<Inscription> getInscriptions() {
        return inscriptionRepository.findAll();
    }

    public Optional<Inscription> getInscription(Integer id) {
        return inscriptionRepository.findById(id);
    }
}
