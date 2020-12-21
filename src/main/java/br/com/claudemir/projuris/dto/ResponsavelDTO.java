package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class ResponsavelDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotNull(message = "nome não pode ser nulo") 
	private String nome;

	private List<ResponsavelOSDTO> responsavelOSs;

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

	public ResponsavelDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public ResponsavelDTO() {
	}

	public List<ResponsavelOSDTO> getResponsavelOSs() {
		return responsavelOSs;
	}

	public void setResponsavelOSs(List<ResponsavelOSDTO> responsavelOSs) {
		this.responsavelOSs = responsavelOSs;
	}

}
