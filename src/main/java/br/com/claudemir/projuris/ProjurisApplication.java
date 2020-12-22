package br.com.claudemir.projuris;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.Cliente;
import br.com.claudemir.projuris.model.entity.OrdemServico;
import br.com.claudemir.projuris.model.entity.Responsavel;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.servico.ClienteService;
import br.com.claudemir.projuris.servico.OrdemServicoService;
import br.com.claudemir.projuris.servico.ResponsavelOsService;
import br.com.claudemir.projuris.servico.ResponsavelService;

@SpringBootApplication
public class ProjurisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjurisApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ResponsavelService responsavelService, ClienteService clienteService,
			OrdemServicoService ordemServicoService, ResponsavelOsService responsavelOsService) {
		return args -> {
			initDados(responsavelService, clienteService, ordemServicoService, responsavelOsService);
		};
	}

	private void initDados(ResponsavelService responsavelService, ClienteService clienteService,
			OrdemServicoService ordemServicoService, ResponsavelOsService responsavelOsService) {

		Cliente cliente = new Cliente(null, "Claudemir Ramos Ferreira", "Rua 01", "9999999", "claudemir@gmail.com");
		clienteService.save(cliente);

		Responsavel responsavel = new Responsavel(null, "Jorge Amado");
		responsavelService.save(responsavel);

		OrdemServico ordemServico = new OrdemServico();
		ordemServico.setCliente(cliente);
		ordemServico.setResponsavel(responsavel);
		ordemServico.setInicio(new Date());
		ordemServico.setDescricao("Computador não liga");
		ordemServico.setMarca("DELL");
		ordemServico.setStatus(Status.ABERTO);
		ordemServico.setTipo("Informatica");
		ordemServicoService.save(ordemServico);
		
		ResponsavelOS responsavelOs = new ResponsavelOS(null, null, new Date(), null, Status.ABERTO, ordemServico, responsavel);
		responsavelOsService.save(responsavelOs);
		
	}

}