package com.backend.gestion_eventos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "inscripciones")
@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer id;

    @Column(name = "fecha_inscripcion")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;
}
