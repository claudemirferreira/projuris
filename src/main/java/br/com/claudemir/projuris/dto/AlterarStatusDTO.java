package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;

public class AlterarStatusDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Ordem de Servico não pode ser nulo")
	private Integer id;

	@NotNull(message = "status não pode ser nulo")
	private Status status;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlterarStatusDTO() {
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}