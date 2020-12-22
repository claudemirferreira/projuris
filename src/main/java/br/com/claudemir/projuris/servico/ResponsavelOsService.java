package br.com.claudemir.projuris.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.dto.AlterarStatusDTO;
import br.com.claudemir.projuris.dto.FecharResponsavelOSDTO;
import br.com.claudemir.projuris.dto.IncluirResponsavelOSDTO;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;

@Service
public interface ResponsavelOsService extends BaseService<ResponsavelOS, Integer> {

	public ResponsavelOS incluirResponsavelOs(IncluirResponsavelOSDTO dto);

	public ResponsavelOS fecharResponsavelOs(FecharResponsavelOSDTO dto);

	public List<ResponsavelOS> findByStatus(Integer id);
	
	public ResponsavelOS alterarStatus(AlterarStatusDTO dto);

}