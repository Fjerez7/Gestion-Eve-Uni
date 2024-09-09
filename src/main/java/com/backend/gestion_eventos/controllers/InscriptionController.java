package com.backend.gestion_eventos.controllers;

import com.backend.gestion_eventos.models.Inscription;
import com.backend.gestion_eventos.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/inscriptions")
@RestController
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping
    public ResponseEntity<Inscription> saveInscription(@RequestBody Inscription inscription) {
        try {
            Inscription newInscription = inscriptionService.saveInscription(inscription);
            return ResponseEntity.ok(newInscription);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInscription(@PathVariable Integer id) {
        try {
            inscriptionService.deleteInscription(id);
            return ResponseEntity.ok().body("Inscription deleted");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Inscription not found");
        }
    }

    @GetMapping
    public ResponseEntity<List<Inscription>> getInscriptions() {
        try {
            List<Inscription> inscriptions = inscriptionService.getInscriptions();
            return ResponseEntity.ok(inscriptions);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getInscription(@PathVariable Integer id) {
        try {
            Inscription inscription = inscriptionService.getInscription(id).orElseThrow();
            return ResponseEntity.ok(inscription);
        }catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
