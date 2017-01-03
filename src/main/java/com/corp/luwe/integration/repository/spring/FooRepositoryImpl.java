package com.corp.luwe.integration.repository.spring;

import java.util.Arrays;
import java.util.List;

import com.corp.luwe.domain.entity.Foo;
import com.corp.luwe.domain.repository.FooRepositoryCustom;

/**
 * @author Ivan Lampert
 */
public class FooRepositoryImpl 
	implements FooRepositoryCustom {

	@Override
	public List<Foo> customFinderBySomeParam(String param) {
		return (Arrays.asList(
			new Foo("Any :" + param, "123", "OOO"),
			new Foo("Any :" + param, "ABC", "PPP")));
	}

}
