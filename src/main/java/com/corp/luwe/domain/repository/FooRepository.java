package com.corp.luwe.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.corp.luwe.domain.entity.Foo;

/**
 * @author Ivan Lampert
 */
@Repository
public interface FooRepository
	extends FooRepositoryCustom, CrudRepository<Foo, Long> {
}
