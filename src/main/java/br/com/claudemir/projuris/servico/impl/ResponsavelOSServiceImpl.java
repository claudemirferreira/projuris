package br.com.claudemir.projuris.servico.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.dto.FecharResponsavelOSDTO;
import br.com.claudemir.projuris.dto.IncluirResponsavelOSDTO;
import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.repository.OrdemServicoRepository;
import br.com.claudemir.projuris.repository.ResponsavelOSRepository;
import br.com.claudemir.projuris.servico.ResponsavelOsService;

@Service
public class ResponsavelOSServiceImpl extends AbstractService<ResponsavelOS, Integer> implements ResponsavelOsService {

	private ResponsavelOSRepository repository;
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	@Autowired
	public ResponsavelOSServiceImpl(ResponsavelOSRepository repository) {
		this.repository = repository;
	}

	@Override
	protected CrudRepository<ResponsavelOS, Integer> getRepository() {
		return repository;
	}

	@Override
	public ResponsavelOS incluirResponsavelOs(IncluirResponsavelOSDTO dto) {
		ResponsavelOS entity = IncluirResponsavelOSDTO.toResponsavelOSEntity(dto);
		return repository.save(entity);
	}

	@Override
	public ResponsavelOS fecharResponsavelOs(FecharResponsavelOSDTO dto) {
		ResponsavelOS entity = repository.findById(dto.getId()).get();
		entity.setFim(new Date());
		entity.setStatus(Status.FECHADO);
		entity.setObservacao(dto.getObservacao());
		//fechar a OS
		OrdemServico ordemServico = entity.getOrdemServico();
		ordemServico.setObservacao(entity.getObservacao());
		ordemServico.setFim(new Date());
		ordemServico.setStatus(Status.FECHADO);
		ordemServicoRepository.save(ordemServico);
		return repository.save(entity);
	}

	@Override
	public List<ResponsavelOS> findByStatus( Integer id) {
		return repository.findByStatus(id);
	}

}
