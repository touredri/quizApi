package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur resultat;
}
