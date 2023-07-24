package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;

@Entity
@Data
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String libelle;
    @Column
    private Boolean reponse;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

}
