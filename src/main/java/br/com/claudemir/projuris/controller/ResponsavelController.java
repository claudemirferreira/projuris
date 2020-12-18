package br.com.claudemir.projuris.controller;

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

import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.repository.ResponsavelRepository;
import br.com.claudemir.projuris.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projuris/api/responsavel/")
@Api(value = "Responsavel")
public class ResponsavelController {

	@Autowired
	private ResponsavelRepository repository;

	@GetMapping("{id}")
	@ApiOperation(value = "pegar Responsavel por id")
	public ResponseEntity<Response<Responsavel>> findById(@PathVariable Integer id) throws Exception {

		Response<Responsavel> response = new Response<Responsavel>();
		try {
			response.setData(repository.findById(id).get());
		} catch (NoSuchElementException e) {
			response.getErrors().add("Nenhum registro encontrado");
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@GetMapping("")
	@ApiOperation(value = "listar todas as ordens de servicos")
	public ResponseEntity<Response<List<Responsavel>>> findAll() throws Exception {
		Response<List<Responsavel>> response = new Response<List<Responsavel>>();
		try {
			response.setData(repository.findAll());
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("")
	@ApiOperation(value = "inclui uma Responsavel")
	public ResponseEntity<Response<Responsavel>> save(@RequestBody Responsavel entity) throws Exception {
		Response<Responsavel> response = new Response<Responsavel>();
		try {
			response.setData(repository.save(entity));
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "deleta uma Responsavel por id")
	public ResponseEntity<Response<Responsavel>> deleteById(@PathVariable Integer id) throws Exception {

		Response<Responsavel> response = new Response<Responsavel>();
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("")
	@ApiOperation(value = "inclui um Responsavel")
	public ResponseEntity<Response<Responsavel>> update(@RequestBody Responsavel entity) throws Exception {
		Response<Responsavel> response = new Response<Responsavel>();
		try {
			response.setData(repository.save(entity));
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

}
