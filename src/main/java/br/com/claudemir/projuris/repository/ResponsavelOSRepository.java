package br.com.claudemir.projuris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.claudemir.projuris.model.entity.ResponsavelOS;

public interface ResponsavelOSRepository extends JpaRepository<ResponsavelOS, Integer> {

	@Query("select u from ResponsavelOS u where u.status = '0' and u.responsavel.id = :id")
	public List<ResponsavelOS> findByStatus(@Param("id") Integer id);
	
}