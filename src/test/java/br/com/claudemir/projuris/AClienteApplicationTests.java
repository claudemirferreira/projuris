package br.com.claudemir.projuris;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.repository.ClienteRepository;

@SpringBootTest
class AClienteApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void testIncluirCliente() {
		Cliente obj = new Cliente(null, "João Ferreira", "rua 01", "999999999", "claudemir@gmail.com");
		Cliente found = clienteRepository.save(obj);
		assertThat(found.getNome()).isEqualTo(obj.getNome());
	}

}
