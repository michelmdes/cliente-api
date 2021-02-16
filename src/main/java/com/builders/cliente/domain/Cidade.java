package com.builders.cliente.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cidade extends GenericDomain<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 255)
	private String nome;


	@ManyToOne
	@JoinColumn(name="id_estado")
	private Estado estado;

	public Cidade() {
	}

	public Cidade(Long id) {
		super();
		this.id = id;
	}

	public Cidade(Long id, @NotBlank String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


}
