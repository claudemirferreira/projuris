package br.com.claudemir.projuris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.dto.ResponsavelDTO;
import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.servico.BaseService;
import br.com.claudemir.projuris.servico.ResponsavelService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/projuris/resposavel/")
@CrossOrigin(origins = "*")
@Api(value = "API rest responsavel")
public class ResponsavelController extends AbstractController<Responsavel, Integer, ResponsavelDTO> {

	@Autowired
	private ResponsavelService service;

	@Override
	protected BaseService<Responsavel, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ResponsavelDTO> getDtoClass() {
		return ResponsavelDTO.class;
	}

	@Override
	protected Class<Responsavel> getEntityClass() {
		return Responsavel.class;
	}

}