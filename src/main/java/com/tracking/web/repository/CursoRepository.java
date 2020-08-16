package com.tracking.web.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracking.web.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
	@Query("SELECT c FROM Curso c WHERE c.nome LIKE %?1%")
	List<Curso> findByName(String nome);
	
	@Query("SELECT c FROM Curso c WHERE c.id = ?1")
	Curso findCursoId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Curso c SET c.nome = ?2 WHERE c.id = ?1")
	void saveNome(Long id, String nome);
}
