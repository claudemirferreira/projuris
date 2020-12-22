package br.com.claudemir.projuris.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.claudemir.projuris.dto.FecharResponsavelOSDTO;
import br.com.claudemir.projuris.dto.IncluirResponsavelOSDTO;
import br.com.claudemir.projuris.dto.ResponsavelOSDTO;
import br.com.claudemir.projuris.enumerated.Status;
import br.com.claudemir.projuris.model.entity.ResponsavelOS;
import br.com.claudemir.projuris.response.Response;
import br.com.claudemir.projuris.servico.BaseService;
import br.com.claudemir.projuris.servico.ResponsavelOsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/projuris/responsavel-os/")
@CrossOrigin(origins = "*")
@Api(value = "API rest responsavel-os")
public class ResponsavelOSController extends AbstractController<ResponsavelOS, Integer, ResponsavelOSDTO> {

	@Autowired
	private ResponsavelOsService service;

	@Override
	protected BaseService<ResponsavelOS, Integer> getService() {
		return service;
	}

	@Override
	protected Class<ResponsavelOSDTO> getDtoClass() {
		return ResponsavelOSDTO.class;
	}

	@Override
	protected Class<ResponsavelOS> getEntityClass() {
		return ResponsavelOS.class;
	}

	@RequestMapping(value = "incluir-responsavel", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "incluir um responsavel pela OS")
	public ResponseEntity<Response<ResponsavelOSDTO>> incluirResponsavelOs(HttpServletResponse resp,
			@Valid @RequestBody IncluirResponsavelOSDTO obj) {

		Response<ResponsavelOSDTO> response = new Response<ResponsavelOSDTO>();
		try {
			ResponsavelOSDTO dto = toDto(service.incluirResponsavelOs(obj));
			response.setContent(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "concluir-os", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "concluir OS")
	public ResponseEntity<Response<ResponsavelOSDTO>> fecharResponsavelOs(HttpServletResponse resp,
			@Valid @RequestBody FecharResponsavelOSDTO obj) {

		Response<ResponsavelOSDTO> response = new Response<ResponsavelOSDTO>();
		try {
			ResponsavelOSDTO dto = toDto(service.fecharResponsavelOs(obj));
			response.setContent(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}

	@RequestMapping(value = "{id}/os-pendentes", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	@ApiOperation(value = "os-pendentes")
	public ResponseEntity<Response<List<ResponsavelOSDTO>>> findOsPorStatus(HttpServletResponse resp,
			@PathVariable("id") Integer id) {

		Response<List<ResponsavelOSDTO>> response = new Response<List<ResponsavelOSDTO>>();
		try {
			List<ResponsavelOSDTO> dto = toDto(service.findByStatus(id));
			response.setContent(dto);
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(response);
		}
	}

}