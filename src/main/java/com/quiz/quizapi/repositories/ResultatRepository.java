package com.quiz.quizapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.quizapi.models.Resultat;
@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    List<Resultat> findAllByQuizId(Long quizId);

    //List<Resultat> findById(int id);

//	List<Resultat> findByUserUsername(String username);
	
	//List<Resultat> findByQuizId(int quizId);
	
}
