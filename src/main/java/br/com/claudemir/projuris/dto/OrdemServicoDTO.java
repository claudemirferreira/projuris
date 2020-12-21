package br.com.claudemir.projuris.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.claudemir.projuris.enumerated.Status;

public class OrdemServicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Date dataCadastro;

	private String descricao;

	private String observacao;

	private String tipo;

	private String marca;

	private Date dataConclusao;

	private Status status;

	private ResponsavelDTO responsavel;

	private ClienteDTO cliente;

	private List<ResponsavelOSDTO> ResponsavelOSs;

	public OrdemServicoDTO() {
	}

	public OrdemServicoDTO(Integer id, Date dataCadastro, String descricao, String observacao, String tipo,
			String marca, Date dataConclusao, Status status, Date inicio, Date fim, ResponsavelDTO responsavel,
			ClienteDTO cliente) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.descricao = descricao;
		this.observacao = observacao;
		this.tipo = tipo;
		this.marca = marca;
		this.dataConclusao = dataConclusao;
		this.status = status;
		this.responsavel = responsavel;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Date getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Date dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ResponsavelDTO getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelDTO responsavel) {
		this.responsavel = responsavel;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<ResponsavelOSDTO> getResponsavelOSs() {
		return ResponsavelOSs;
	}

	public void setResponsavelOSs(List<ResponsavelOSDTO> responsavelOSs) {
		ResponsavelOSs = responsavelOSs;
	}

}