package com.corp.luwe.domain.repository;

import java.util.List;

import com.corp.luwe.domain.entity.Foo;

/**
 * @author Ivan Lampert
 */
public interface FooRepositoryCustom {

	public List<Foo> customFinderBySomeParam(String param);
}
