package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;

@Entity
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
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
