package com.quiz.quizapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Administrateur extends Personne {

        @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Quiz> quizzes = new ArrayList<>();

        public List<Quiz> getQuizzes() {
            return quizzes;
        }

        public void setQuizzes(List<Quiz> quiz) {
            this.quizzes = quiz;
        }
}
