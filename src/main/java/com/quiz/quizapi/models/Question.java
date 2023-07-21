package com.quiz.quizapi.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {
    @Id
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column (nullable = false)
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    @OneToMany(mappedBy = "Reponse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reponse> reponse = new ArrayList<>();

    public List<Reponse> getReponse() {
        return reponse;
    }

    public void setReponse(List<Reponse> reponse) {
        this.reponse = reponse;
    }
}
