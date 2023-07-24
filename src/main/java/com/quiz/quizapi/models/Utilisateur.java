package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String pseudo;


    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String motdepasse;

    @OneToMany(mappedBy = "resultat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultat> resultats;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> listQuiz;
}
