package com.tracking.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tracking.apirest.models.Apresentacao;
import com.tracking.apirest.models.Curso;
import com.tracking.apirest.models.Palestra;
import com.tracking.apirest.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	@Query("SELECT t FROM Usuario t WHERE t.nome LIKE %?1%")
	List<Usuario> findName(String nome);
	
	@Query("SELECT u FROM Usuario u WHERE u.id = ?1")
	Usuario findUsuarioId(Long id);
	
	Usuario findByCurso(Curso curso);
	
	Usuario findByPalestra(Palestra palestra);
	
	Usuario findByApresentacao(Apresentacao apresentacao);
}
