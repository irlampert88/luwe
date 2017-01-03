package com.corp.luwe.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corp.luwe.domain.entity.Restaurant;

/**
 * @author Ivan Lampert
 */
@Repository
public interface RestaurantRepository 
	extends CrudRepository<Restaurant, Long> {
}
