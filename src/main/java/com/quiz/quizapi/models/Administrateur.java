package com.quiz.quizapi.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Administrateur extends Personne {
        public Administrateur() {
            super();
        }
        @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL)
        private List<Quiz> quizzes = new ArrayList<>();
}
