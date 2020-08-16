package com.tracking.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.apirest.models.Usuario;
import com.tracking.apirest.models.Curso;
import com.tracking.apirest.repository.CursoRepository;
import com.tracking.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class CursoController {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Inserir curso para o usuario
	@PostMapping("/curso/{id}")
	public String inserirCursoParaUsuario(@PathVariable(value="id") Long id, @RequestBody Curso curso) {
		if(curso.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		Usuario usuario = usuarioRepository.findUsuarioId(id);
		curso.setUsuario(usuario);
		usuario.setCurso(curso);
		usuarioRepository.save(usuario);
		return "Curso Criado";
	}
	
	//Alterar informações do curso do usuario
	@PostMapping("/curso/editar")
	public String alterarCursoParaUsuario(@RequestBody Curso curso) {
		if(curso.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		cursoRepository.saveNome(curso.getId(), curso.getNome());
		return "Curs Alterado";
	}
	
	//Deletar curso do usuario
	@DeleteMapping("/curso/{id}")
	public String deletarCursoParaUsuario(@PathVariable(value="id") Long id) {
		Curso curso = cursoRepository.findCursoId(id);
		cursoRepository.delete(curso);
		return "Curso Deletado";
	}
}
