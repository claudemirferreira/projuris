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

import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.repository.ClienteRepository;
import br.com.claudemir.projuris.response.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projuris/api/cliente/")
@Api(value = "cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;

	@GetMapping("{id}")
	@ApiOperation(value = "pegar cliente por id")
	public ResponseEntity<Response<Cliente>> findById(@PathVariable Integer id) throws Exception {

		Response<Cliente> response = new Response<Cliente>();
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
	public ResponseEntity<Response<List<Cliente>>> findAll() throws Exception {
		Response<List<Cliente>> response = new Response<List<Cliente>>();
		try {
			response.setData(repository.findAll());
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@PostMapping("")
	@ApiOperation(value = "inclui uma cliente")
	public ResponseEntity<Response<Cliente>> save(@RequestBody Cliente entity) throws Exception {
		Response<Cliente> response = new Response<Cliente>();
		try {
			response.setData(repository.save(entity));
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("{id}")
	@ApiOperation(value = "deleta uma cliente por id")
	public ResponseEntity<Response<Cliente>> deleteById(@PathVariable Integer id) throws Exception {

		Response<Cliente> response = new Response<Cliente>();
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

	@PutMapping("")
	@ApiOperation(value = "inclui um cliente")
	public ResponseEntity<Response<Cliente>> update(@RequestBody Cliente entity) throws Exception {
		Response<Cliente> response = new Response<Cliente>();
		try {
			response.setData(repository.save(entity));
		} catch (Exception e) {
			response.getErrors().add("Ocorreu um error no sistema");
		}
		return ResponseEntity.ok(response);
	}

}
