package com.tracking.apirest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Usuario")
public class Usuario{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long usuario_id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private String email;
	
	@NotNull
	private String telefone;
	
	@NotNull
	private String area;
	
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
	private List<Curso> curso;
	
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
	private List<Apresentacao> apresentacao;
	
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL)
	private List<Palestra> palestra;

	public List<Curso> getCursos() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso.add(curso);
	}

	public List<Apresentacao> getApresentacoes() {
		return apresentacao;
	}

	public void setApresentacao(Apresentacao apresentacao) {
		this.apresentacao.add(apresentacao);
	}

	public List<Palestra> getPalestras() {
		return palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra.add(palestra);
	}

	public long getId() {
		return usuario_id;
	}

	public void setId(long id) {
		this.usuario_id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
