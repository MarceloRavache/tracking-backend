package com.tracking.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tracking.web.models.Palestra;
import com.tracking.web.models.Usuario;
import com.tracking.web.repository.PalestraRepository;
import com.tracking.web.repository.UsuarioRepository;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PalestraController {
	
	@Autowired
	PalestraRepository palestraRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	//Inserir palestra para o usuario
	@PostMapping("/palestra/{id}")
	public String criarPalestraParaUsuario(@PathVariable(value="id") Long id, @RequestBody Palestra palestra) {
		if(palestra.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		Usuario usuario = usuarioRepository.findUsuarioId(id);
		palestra.setUsuario(usuario);
		usuario.setPalestra(palestra);
		usuarioRepository.save(usuario);
		return "Palestra Criada";
	}
	
	//Alterar informações da palestra do usuario
	@PostMapping("/palestra/editar")
	public String alterarPalestraParaUsuario(@RequestBody Palestra palestra) {
		if(palestra.getNome() == "") {
			return "Nome não pode ser vazio";
		}
		palestraRepository.saveNome(palestra.getId(), palestra.getNome());
		return "Palestra Alterada";
	}
	
	//Deletar palestra do usuario
	@DeleteMapping("/palestra/{id}")
	public String deletarPalestraParaUsuario(@PathVariable(value="id") Long id) {
		Palestra palestra = palestraRepository.findPalestraId(id);
		palestraRepository.delete(palestra);
		return "Palestra Deletada";
	}

}
