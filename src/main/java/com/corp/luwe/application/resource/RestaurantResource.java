package com.corp.luwe.application.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.luwe.domain.entity.Restaurant;
import com.corp.luwe.domain.repository.RestaurantRepository;

/**
 * @author Ivan Lampert
 */
@RestController
@RequestMapping(path = "/restaurants")
public final class RestaurantResource 
	extends AbstractCrudResource<Restaurant, Long> {
	
	@Autowired
	public RestaurantResource(RestaurantRepository repository) {
		super(repository);
	}

}
