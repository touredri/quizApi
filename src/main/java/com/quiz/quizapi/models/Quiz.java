package com.quiz.quizapi.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titre;

    @Column (nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> question;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultat> resultats;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

}
