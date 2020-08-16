package com.tracking.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.apirest.models.Apresentacao;
import com.tracking.apirest.models.Usuario;
import com.tracking.apirest.repository.ApresentacaoRepository;
import com.tracking.apirest.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class ApresentacaoController {
	
	@Autowired
	ApresentacaoRepository apresentacaoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Inserir Apresentação para o usuario
	@PostMapping("/apresentacao/{id}")
	public String criarApresentacaoParaUsuario(@PathVariable(value="id") Long id, @RequestBody Apresentacao apresentacao) {
		if(apresentacao.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		Usuario usuario = usuarioRepository.findUsuarioId(id);
		apresentacao.setUsuario(usuario);
		usuario.setApresentacao(apresentacao);
		usuarioRepository.save(usuario);
		return "Apresentação Criada";
	}
	
	//Alterar informações da atividade do usuario
	@PostMapping("/apresentacao/editar")
	public String alterarApresentacaoParaUsuario(@RequestBody Apresentacao apresentacao) {
		if(apresentacao.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		apresentacaoRepository.saveNome(apresentacao.getId(), apresentacao.getNome());
		return "Apresentação Alterada";
	}
	
	//Deletar curso do usuario
	@DeleteMapping("/apresentacao/{id}")
	public String deletarApresentacaoParaUsuario(@PathVariable(value="id") Long id) {
		Apresentacao apresentacao = apresentacaoRepository.findApresentacaoId(id);
		apresentacaoRepository.delete(apresentacao);
		return "Apresentação Deletada";
	}
}
