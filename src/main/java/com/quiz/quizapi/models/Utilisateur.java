package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Utilisateur extends Personne {
    public Utilisateur() {
        super();
    }

    @OneToMany(mappedBy = "resultat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultat> resultats = new ArrayList<>();

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> listQuiz = new ArrayList<>();
}
