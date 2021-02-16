package com.builders.cliente.domain;

import com.builders.cliente.utils.DateUtils;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Cliente extends GenericDomain<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@Size(max = 255)
	private String nome;
	@NotNull
	private Date dataNascimento;
	@CPF
	private String cpf;
	@Size(max = 13)
	private String rg;
	@Email
	private String email;
	@Size(min = 10, max = 20)
	private String telefone;
	@Transient
	private Integer idade;

	@ManyToOne
	@JoinColumn(name="id_genero")
	private Genero genero;

//	@OneToMany(mappedBy="cliente")
//	private List<Endereco> enderecos = new ArrayList<>();


	public Cliente() {
	}

	public Cliente(Long id) {
		this.id = id;
	}

	public Cliente(String nome, Date dataNascimento, String cpf, String rg, String email, String telefone, Genero genero /*, List<Endereco> enderecos*/) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.telefone = telefone;
		this.genero = genero;
//		this.enderecos = enderecos;
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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.idade = null;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	/*public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}*/

	public Integer getIdade() {
		if (this.idade != null)
			return this.idade;

		if (getDataNascimento() == null)
			this.idade = null;
		else
			this.idade = DateUtils.calculaIdade(getDataNascimento());

		return this.idade;
	}

}
