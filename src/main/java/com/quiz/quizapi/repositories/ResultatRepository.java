package com.quiz.quizapi.repositories;

import java.util.List;
import java.util.Optional;

import com.quiz.quizapi.models.Quiz;
import com.quiz.quizapi.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.quizapi.models.Resultat;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat> findAllByQuizId(Long quizId);

    Resultat findByUtilisateur_IdAndQuiz_Id(@Param("user") Long user_id, @Param("quiz") Long quiz_id);

    // Autres méthodes de requête personnalisée si nécessaire

}
