package br.com.claudemir.projuris;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.repository.ClienteRepository;
import br.com.claudemir.projuris.repository.OrdemServicoRepository;
import br.com.claudemir.projuris.repository.ResponsavelRepository;

@SpringBootTest
class OordemServicoApplicationTests {
	

	@Autowired
	private OrdemServicoRepository ordemServicoRepository;


	@Test
	void contextLoads() {

	}

	@Test
	public void testIncluirOS() {
		Cliente cliente = new Cliente();
		cliente.setId(1);
		
		Responsavel responsavel = new Responsavel();
		responsavel.setId(1);
		
		
		OrdemServico obj = new OrdemServico(
				null, 
				new Date(), 
				"Computador com defeito", 
				null, 
				"Eletronio", 
				"DELL", 
				null, 
				Status.ABERTO, 
				null, 
				null, 
				responsavel, 
				cliente);
		
		OrdemServico found = ordemServicoRepository.save(obj);
		assertThat(found.getDescricao()).isEqualTo(obj.getDescricao());
	}

}
