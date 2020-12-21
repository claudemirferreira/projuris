package br.com.claudemir.projuris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.dto.ResponsavelOSDTO;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.servico.BaseService;
import br.com.claudemir.projuris.servico.ResponsavelOsService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/projuris/responsavel-os/")
@CrossOrigin(origins = "*")
@Api(value = "API rest responsavel-os")
public class ReponsavelOSController extends AbstractController<ResponsavelOS, Integer, ResponsavelOSDTO> {

	@Autowired
	private ResponsavelOsService service;

	@Override
	protected BaseService<ResponsavelOS, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ResponsavelOSDTO> getDtoClass() {
		return ResponsavelOSDTO.class;
	}

	@Override
	protected Class<ResponsavelOS> getEntityClass() {
		return ResponsavelOS.class;
	}

}