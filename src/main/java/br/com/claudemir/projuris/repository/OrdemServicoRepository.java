package br.com.claudemir.projuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.projuris.model.entity.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Integer> {

}