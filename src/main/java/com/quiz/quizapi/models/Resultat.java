package com.quiz.quizapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Resultat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long score;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    /*

    @Override
    public String toString() {
        return "Resultat{" +
                "id=" + id +
                ", Score=" + Score +
                ", utilisateur=" + utilisateur +
                '}';
    }*/
}
