package com.quiz.quizapi.repositories;

import com.quiz.quizapi.models.Reponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReponseRepository extends JpaRepository<Reponse, Long> {
    List<Reponse> findAllByQuestionId(Long questionId);
}
