package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

public class ResponsavelOSDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String observacao;

	private Date inicio;

	private Date fim;

	@NotNull(message = "Ordem de Servico não pode ser nulo") 
	private OrdemServicoDTO ordemServico;

	@NotNull(message = "responsavel não pode ser nulo") 
	private ResponsavelDTO responsavel;

	public OrdemServicoDTO getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServicoDTO ordemServico) {
		this.ordemServico = ordemServico;
	}

	public ResponsavelDTO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelDTO responsavel) {
		this.responsavel = responsavel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public ResponsavelOSDTO() {
	}

	public ResponsavelOSDTO(Integer id, String observacao, Date inicio, Date fim, OrdemServicoDTO ordemServico,
			ResponsavelDTO responsavel) {
		this.id = id;
		this.observacao = observacao;
		this.inicio = inicio;
		this.fim = fim;
		this.ordemServico = ordemServico;
		this.responsavel = responsavel;
	}

}
