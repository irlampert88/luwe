package com.corp.luwe.domain.service.impl;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.corp.luwe.domain.entity.AbstractEntity;

/**
 * @author Ivan Lampert
 */
abstract class AbstractCrudService<R extends CrudRepository<E, ID>, E extends AbstractEntity<ID>, ID extends Serializable> {

	private R repository;

	public AbstractCrudService(R repository) {
		this.repository = repository;
	}
	
	final R getRepository() {
		return repository;
	}
	
}
