package com.tracking.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.apirest.models.Usuario;
import com.tracking.apirest.repository.ApresentacaoRepository;
import com.tracking.apirest.repository.CursoRepository;
import com.tracking.apirest.repository.PalestraRepository;
import com.tracking.apirest.repository.UsuarioRepository;
import com.tracking.apirest.utils.ConsultaNome;

import java.util.List;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class UsuarioController {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	PalestraRepository palestraRepository;
	@Autowired
	ApresentacaoRepository apresentacaoRepository;
	
	//Listar usuarios
	@PostMapping("/usuario/pesquisar")
	public List<Usuario> listarUsuarios(@RequestBody ConsultaNome nome){
		return usuarioRepository.findName(nome.getNome());
	}
	
	//Consultar as informações do usuario
	@GetMapping("/usuario/{id}")
	public Usuario consultarUsuario(@PathVariable(value="id") Long id) {
		Usuario usuario = usuarioRepository.findUsuarioId(id);
		return usuario;
	}
	
	//Criar usuario
	@PostMapping("/usuario")
	public String criarUsuario(@RequestBody Usuario usuario) {
		if(usuario.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		if(usuario.getEndereco() == "") {
			return "Endereço não pode ser vazio";
		}
		if(usuario.getEmail() == "") {
			return "Email não pode ser vazio";
		}
		if(usuario.getTelefone() == "") {
			return "Telefone não pode ser vazio";
		}
		if(usuario.getArea() == "") {
			return "Área não pode ser vazio";
		}
		usuarioRepository.save(usuario);
		return "Usuario Criado";
		
	}
	
	//Deletar usuario
	@DeleteMapping("/usuario/{id}")
	public String deletarUsuario(@PathVariable(value="id") Long id) {
		Usuario usuario = usuarioRepository.findUsuarioId(id);
		usuarioRepository.delete(usuario);
		return "Usuario Deletado";
	}
	
	//Alterar usuario
	@PostMapping("/usuario/editar")
	public String atualizarUsuario(@RequestBody Usuario usuario) {
		if(usuario.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		if(usuario.getEndereco() == "") {
			return "Endereço não pode ser vazio";
		}
		if(usuario.getEmail() == "") {
			return "Email não pode ser vazio";
		}
		if(usuario.getTelefone() == "") {
			return "Telefone não pode ser vazio";
		}
		if(usuario.getArea() == "") {
			return "Área não pode ser vazio";
		}
		usuarioRepository.save(usuario);
		return "Usuario Alterado";
	}
	
}
