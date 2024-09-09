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
@Table(name = "comentarios")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comentario")
    private Integer id;

    @Column(name = "text_comentario")
    private String text;

    @Column(name = "fecha_comentario")
    private LocalDateTime date;

    @Column(name = "puntuacion_comentario")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

}
