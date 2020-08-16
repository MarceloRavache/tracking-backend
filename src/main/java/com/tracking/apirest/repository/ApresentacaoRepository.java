package com.tracking.apirest.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tracking.apirest.models.Apresentacao;

public interface ApresentacaoRepository extends JpaRepository<Apresentacao, Long>{

	@Query("SELECT a FROM Apresentacao a WHERE a.nome LIKE %?1%")
	List<Apresentacao> findByName(String nome);
	
	@Query("SELECT a FROM Apresentacao a WHERE a.id = ?1")
	Apresentacao findApresentacaoId(Long id);
	
	@Transactional
	@Modifying
	@Query("UPDATE Apresentacao a SET a.nome = ?2 WHERE a.id = ?1")
	void saveNome(Long id, String nome);
}
