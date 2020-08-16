package com.tracking.apirest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="Curso")
public class Curso{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long curso_id;
	
	@NotNull
	private String nome;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName="usuario_id")
	private Usuario usuario;

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return curso_id;
	}

	public void setId(long id) {
		this.curso_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
