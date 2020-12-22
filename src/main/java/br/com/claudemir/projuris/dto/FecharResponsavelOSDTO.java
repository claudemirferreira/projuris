package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import br.com.claudemir.projuris.model.entity.ResponsavelOS;

public class FecharResponsavelOSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "Ordem de Servico não pode ser nulo")
	private Integer id;

	@NotNull(message = "observacao não pode ser nulo")
	private String observacao;

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FecharResponsavelOSDTO() {
	}

	public FecharResponsavelOSDTO(Integer id, String observacao) {
		this.observacao = observacao;
	}

	public static ResponsavelOS toResponsavelOSEntity(FecharResponsavelOSDTO dto) {
		ResponsavelOS entity = new ResponsavelOS();
		entity.setInicio(new Date());
		return entity;

	}

}
