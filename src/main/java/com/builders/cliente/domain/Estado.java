package com.builders.cliente.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estado extends GenericDomain<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 255)
	private String nome;
	@NotBlank
	@Size(max = 2)
	private String sigla;
	
	@JsonIgnore
	@OneToMany(mappedBy="estado")
	private List<Cidade> cidades = new ArrayList<>();
	
	public Estado() {
	}

	public Estado(Long id, @NotBlank String nome, @NotBlank String sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
