package br.com.claudemir.projuris.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.claudemir.projuris.enumerated.Status;

@Entity
@Table(name = "responsavel_os")
public class ResponsavelOS implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_resp_os")
	private Integer id;

	@Column(length = 200)
	private String observacao;

	@Column(nullable = false)
	private Date inicio;
	
	private Date fim;
	
	@NotNull(message = "status não pode ser nulo") 
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;
	
	@ManyToOne
	@JoinColumn(name = "id_ordem_servico")
	private OrdemServico ordemServico;
	
	public ResponsavelOS() {}
	
	public ResponsavelOS(Integer id, String observacao, Date inicio, Date fim, Status status, OrdemServico ordemServico, Responsavel responsavel) {
		this.id = id;
		this.observacao = observacao;
		this.inicio = inicio;
		this.fim = fim;
		this.status = status;
		this.ordemServico = ordemServico;
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

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public OrdemServico getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(OrdemServico ordemServico) {
		this.ordemServico = ordemServico;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponsavelOS other = (ResponsavelOS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
