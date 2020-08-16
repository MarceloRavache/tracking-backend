package com.tracking.apirest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracking.apirest.models.Palestra;

public interface PalestraRepository extends JpaRepository<Palestra, Long> {

	@Query("SELECT p FROM Palestra p WHERE p.nome LIKE %?1%")
	List<Palestra> findByName(String nome);
	
	@Query("SELECT p FROM Palestra p WHERE p.id = ?1")
	Palestra findPalestraId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Palestra p SET p.nome = ?2 WHERE p.id = ?1")
	void saveNome(Long id, String nome);
}
