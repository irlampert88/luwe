package com.corp.luwe.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corp.luwe.domain.entity.Elector;

/**
 * @author Ivan Lampert
 */
@Repository
public interface ElectorRepository 
	extends CrudRepository<Elector, Long> {
	
}
