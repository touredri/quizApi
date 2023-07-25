package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultat> resultat;

    public List<Resultat> getResultat() {
        return resultat;
    }

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> listQuiz;


}
