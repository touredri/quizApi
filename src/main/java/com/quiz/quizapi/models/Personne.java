package com.quiz.quizapi.models;

import jakarta.persistence.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personne {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column (nullable = false)
    private String pseudo;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(Spring pseudo) {
        this.pseudo = pseudo.toString();
    }


    @Column (nullable = false)
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column (nullable = false)
    private String motdepasse;

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Quiz> quiz = new ArrayList<>();
}
