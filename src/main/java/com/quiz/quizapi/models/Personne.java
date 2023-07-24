package com.quiz.quizapi.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    private String pseudo;


    @Column (nullable = false)
    private String email;

    @Column (nullable = false)
    private String motdepasse;

}
