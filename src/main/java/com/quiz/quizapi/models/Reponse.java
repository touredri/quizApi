package com.quiz.quizapi.models;

import jakarta.persistence.*;

import javax.swing.*;

@Entity
public class Reponse {
    @Id
    private Long id;
    @Column (nullable = false)
    private String libele;
    @Column (nullable = false)
    private int question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question questions;

    public Question getQuestions() {
        return questions;
    }

    public void setQuestions(Question questions) {
        this.questions = questions;
    }
}
