package br.com.claudemir.projuris.controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.repository.OrdemServicoRepository;
import br.com.claudemir.projuris.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projuris/api/ordem-servico/")
@Api(value = "ordem-servico")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoRepository repository;

	@GetMapping("{id}")
	@ApiOperation(value = "pegar ordem de servico por id")
	public ResponseEntity<Response<OrdemServico>> findById(@PathVariable Integer id) throws Exception {

		Response<OrdemServico> response = new Response<OrdemServico>();
		try {
			response.setData(repository.findById(id).get());
		} catch (NoSuchElementException e) {
			response.getErrors().add("Nenhum registro encontrado");
		}catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("")
	@ApiOperation(value = "listar todas as ordens de servicos")
	public ResponseEntity<Response<List<OrdemServico>>> findAll() throws Exception {
		Response<List<OrdemServico>> response = new Response<List<OrdemServico>>();
		try {
			response.setData(repository.findAll());
		}catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("")
	@ApiOperation(value = "inclui uma ordem de servico")
	public ResponseEntity<Response<OrdemServico>> save(@RequestBody OrdemServico entity) throws Exception {
		Response<OrdemServico> response = new Response<OrdemServico>();
		try {
			entity.setDataCadastro(new Date());
			entity.setDataConclusao(null);
			entity.setStatus(Status.ABERTO);
			response.setData(repository.save(entity));
		}catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("{id}")
	@ApiOperation(value = "deleta uma ordem de servico por id")
	public ResponseEntity<Response<OrdemServico>> deleteById(@PathVariable Integer id) throws Exception {

		Response<OrdemServico> response = new Response<OrdemServico>();
		try {
			repository.deleteById(id);
		}catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("")
	@ApiOperation(value = "inclui uma ordem de servico")
	public ResponseEntity<Response<OrdemServico>> update(@RequestBody OrdemServico entity) throws Exception {
		Response<OrdemServico> response = new Response<OrdemServico>();
		try {
			response.setData(repository.save(entity));
		}catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

}
