package com.quiz.quizapi.models;
import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Quiz {
    public Quiz() {

    }
    @Id
    private Long id;
    @Column(nullable = false)
    private String titre;

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    @Column (nullable = false)
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Long getId() {
        return id;
    }
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> question = new ArrayList<>();

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @ManyToOne
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;
}
