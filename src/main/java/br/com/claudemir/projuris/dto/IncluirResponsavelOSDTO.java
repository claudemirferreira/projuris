package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;

public class IncluirResponsavelOSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "observacao não pode ser nulo")
	private String observacao;

	@NotNull(message = "Ordem de Servico não pode ser nulo")
	private Integer idOrdemServico;

	@NotNull(message = "responsavel de Servico não pode ser nulo")
	private Integer idResponsavel;
	
	public Integer getIdOrdemServico() {
		return idOrdemServico;
	}

	public void setIdOrdemServico(Integer idOrdemServico) {
		this.idOrdemServico = idOrdemServico;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public IncluirResponsavelOSDTO() {
	}

	public IncluirResponsavelOSDTO(Integer id, String observacao, Integer idOrdemServico,
			Integer idResponsavel) {
		this.observacao = observacao;
		this.idOrdemServico = idOrdemServico;
		this.idResponsavel = idResponsavel;
	}
	
	public static ResponsavelOS toResponsavelOSEntity(IncluirResponsavelOSDTO dto) {
		ResponsavelOS entity = new ResponsavelOS();
		entity.setInicio(new Date());
		entity.setStatus(Status.ABERTO);
		entity.setResponsavel(new Responsavel(dto.getIdResponsavel()));
		entity.setOrdemServico(new OrdemServico(dto.getIdOrdemServico()));		
		return entity;
		
	}

}
