package br.com.claudemir.projuris.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.repository.OrdemServicoRepository;
import br.com.claudemir.projuris.servico.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl extends AbstractService<OrdemServico, Integer> implements OrdemServicoService {

	private OrdemServicoRepository repository;

	@Autowired
	public OrdemServicoServiceImpl(OrdemServicoRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<OrdemServico, Integer> getRepository() {
		return repository;
	}

	@Override
	public OrdemServico fecharOrdemServicoService(OrdemServico entity) {
		return repository.save(entity);
	}
	

}
