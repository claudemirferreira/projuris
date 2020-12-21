package br.com.claudemir.projuris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.dto.ClienteDTO;
import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.servico.BaseService;
import br.com.claudemir.projuris.servico.ClienteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/projuris/cliente/")
@CrossOrigin(origins = "*")
@Api(value = "API rest produto")
public class ClienteController extends AbstractController<Cliente, Integer, ClienteDTO> {

	@Autowired
	private ClienteService service;

	@Override
	protected BaseService<Cliente, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ClienteDTO> getDtoClass() {
		return ClienteDTO.class;
	}

	@Override
	protected Class<Cliente> getEntityClass() {
		return Cliente.class;
	}

}