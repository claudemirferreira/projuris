package br.com.claudemir.projuris.servico;

import org.springframework.stereotype.Service;

import br.com.claudemir.projuris.dto.FecharResponsavelOSDTO;
import br.com.claudemir.projuris.dto.IncluirResponsavelOSDTO;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;

@Service
public interface ResponsavelOsService extends BaseService<ResponsavelOS, Integer> {
	
	public ResponsavelOS incluirResponsavelOs(IncluirResponsavelOSDTO dto);
	
	public ResponsavelOS fecharResponsavelOs(FecharResponsavelOSDTO dto);

}