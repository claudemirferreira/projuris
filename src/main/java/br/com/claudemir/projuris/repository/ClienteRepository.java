package br.com.claudemir.projuris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.claudemir.projuris.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}