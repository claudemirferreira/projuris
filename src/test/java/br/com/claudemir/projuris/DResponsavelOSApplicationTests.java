package br.com.claudemir.projuris;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.repository.ResponsavelOSRepository;

@SpringBootTest
class DResponsavelOSApplicationTests {

	@Autowired
	private ResponsavelOSRepository repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testIncluirResponsavel() {
		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setId(1);

		Responsavel responsavel = new Responsavel();
		responsavel.setId(1);

		ResponsavelOS obj = new ResponsavelOS(null, null, new Date(), null, Status.ABERTO, ordemServico, responsavel);
		ResponsavelOS found = repo.save(obj);
		assertThat(found.getId() > 0);
	}
}
