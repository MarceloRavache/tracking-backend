package com.tracking.apirest.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.apirest.models.Apresentacao;
import com.tracking.apirest.models.Curso;
import com.tracking.apirest.models.Palestra;
import com.tracking.apirest.models.Usuario;
import com.tracking.apirest.repository.ApresentacaoRepository;
import com.tracking.apirest.repository.CursoRepository;
import com.tracking.apirest.repository.PalestraRepository;
import com.tracking.apirest.repository.UsuarioRepository;
import com.tracking.apirest.utils.ConsultaNome;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class AtividadeController {
	
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	PalestraRepository palestraRepository;
	@Autowired
	ApresentacaoRepository apresentacaoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	//consultar atividades
	@PostMapping("/atividade")
	public List<Usuario> consultarAtividade(@RequestBody ConsultaNome nome){
		List<Curso> cursos = cursoRepository.findByName(nome.getNome());
		List<Apresentacao> apresentacoes = apresentacaoRepository.findByName(nome.getNome());
		List<Palestra> palestras = palestraRepository.findByName(nome.getNome());
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		for(int i = 0; i<cursos.size();i++) {
			usuarios.add(usuarioRepository.findByCurso(cursos.get(i)));
		}
		for(int i = 0; i<palestras.size();i++) {
			usuarios.add(usuarioRepository.findByPalestra(palestras.get(i)));
		}
		for(int i = 0; i<apresentacoes.size();i++) {
			usuarios.add(usuarioRepository.findByApresentacao(apresentacoes.get(i)));
		}
		return usuarios;
	}
}
