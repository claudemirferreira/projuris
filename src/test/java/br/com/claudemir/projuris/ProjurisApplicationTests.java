package br.com.claudemir.projuris;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.repository.ResponsavelRepository;

@SpringBootTest
class ProjurisApplicationTests {
	@Autowired
	private ResponsavelRepository repo;

	@Test
	void contextLoads() {

	}

	@Test
	public void testIncluir() {
		Responsavel obj = new Responsavel(null, "JOÃO LEVI FERREIRA");
		Responsavel found = repo.save(new Responsavel(null, "JOÃO LEVI FERREIRA"));
		assertThat(found.getNome()).isEqualTo(obj.getNome());
	}

}
