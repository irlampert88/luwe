package com.corp.luwe.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.luwe.domain.entity.Elector;
import com.corp.luwe.domain.repository.ElectorRepository;

/**
 * @author Ivan Lampert
 */
@RestController
@RequestMapping(path = "/electors")
public class ElectorResource 
	extends AbstractCrudResource<Elector, Long> {
	
	@Autowired
	public ElectorResource(ElectorRepository repository) {
		super(repository);
	}

}
