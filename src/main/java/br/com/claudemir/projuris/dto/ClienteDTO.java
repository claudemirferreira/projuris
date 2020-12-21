package br.com.claudemir.projuris.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "nome não pode ser nulo") 
	private String nome;

	@NotNull(message = "endereco não pode ser nulo") 
	private String endereco;

	@NotNull(message = "telefone não pode ser nulo") 
	private String telefone;

	@NotNull(message = "email não pode ser nulo") 
	@Email(message = "email invalido")
	private String email;

	public ClienteDTO() {
	}

	public ClienteDTO(Integer id, String nome, String endereco, String telefone, String email) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
