package br.com.claudemir.projuris.servico;

import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.model.entity.OrdemServico;

@Service
public interface OrdemServicoService extends BaseService<OrdemServico, Integer> {

	public OrdemServico fecharOrdemServicoService(OrdemServico entity);
}