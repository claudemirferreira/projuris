package br.com.claudemir.projuris.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.repository.ResponsavelRepository;
import br.com.claudemir.projuris.servico.ResponsavelService;

@Service
public class ResponsavelServiceImpl extends AbstractService<Responsavel, Integer> implements ResponsavelService {

	private ResponsavelRepository repository;

	@Autowired
	public ResponsavelServiceImpl(ResponsavelRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<Responsavel, Integer> getRepository() {
		return repository;
	}

}
