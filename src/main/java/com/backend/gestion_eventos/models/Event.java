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
@Table(name = "eventos")
@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private Integer id;

    @Column(name = "titulo_evento")
    private String title;

    @Column(name = "descripcion_evento")
    private String description;

    @Column(name = "ubicacion_evento")
    private String location;

    @Column(name = "horainicio_evento")
    private LocalDateTime startHour;

    @Column(name = "horafin_evento")
    private LocalDateTime endHour;

    @Column(name = "fechacreacion_evento")
    private LocalDateTime creationDate;

    @Column(name = "imagen_evento")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "id_programa")
    private Program program;
}
