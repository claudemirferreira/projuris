package br.com.claudemir.projuris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.dto.OrdemServicoDTO;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.servico.BaseService;
import br.com.claudemir.projuris.servico.OrdemServicoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/projuris/ordem-servico/")
@CrossOrigin(origins = "*")
@Api(value = "API rest ordem-servico")
public class OrdemServicoController extends AbstractController<OrdemServico, Integer, OrdemServicoDTO> {

	@Autowired
	private OrdemServicoService service;

	@Override
	protected BaseService<OrdemServico, Integer> getService() {
		return service;
	}

	@Override
	protected Class<OrdemServicoDTO> getDtoClass() {
		return OrdemServicoDTO.class;
	}

	@Override
	protected Class<OrdemServico> getEntityClass() {
		return OrdemServico.class;
	}

}