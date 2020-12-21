package br.com.claudemir.projuris.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.repository.ClienteRepository;
import br.com.claudemir.projuris.servico.ClienteService;

@Service
public class ClienteServiceImpl extends AbstractService<Cliente, Integer> implements ClienteService {

	private ClienteRepository repository;

	@Autowired
	public ClienteServiceImpl(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Cliente, Integer> getRepository() {
		return repository;
	}

}
