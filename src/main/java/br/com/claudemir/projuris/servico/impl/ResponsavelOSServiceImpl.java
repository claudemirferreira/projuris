package br.com.claudemir.projuris.servico.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.repository.ResponsavelOSRepository;
import br.com.claudemir.projuris.servico.ResponsavelOsService;

@Service
public class ResponsavelOSServiceImpl extends AbstractService<ResponsavelOS, Integer> implements ResponsavelOsService {

	private ResponsavelOSRepository repository;

	@Autowired
	public ResponsavelOSServiceImpl(ResponsavelOSRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<ResponsavelOS, Integer> getRepository() {
		return repository;
	}

}
