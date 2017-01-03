package com.corp.luwe.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.luwe.domain.entity.Foo;
import com.corp.luwe.domain.repository.FooRepository;
import com.corp.luwe.domain.service.FooService;

/**
 * @author Ivan Lampert
 */
@Service
public final class FooServiceImpl
	extends AbstractCrudService<FooRepository, Foo, Long>
		implements FooService {

	@Autowired
	public FooServiceImpl(FooRepository repository) {
		super(repository);
	}
	
}
