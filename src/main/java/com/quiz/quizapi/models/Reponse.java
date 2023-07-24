package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;

@Entity
@Data
public class Reponse {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false)
    private String libele;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

}
