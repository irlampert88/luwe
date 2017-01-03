package com.corp.luwe.application.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Lampert
 */
@RestController
@RequestMapping("/foos")
public final class FooResource {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "Foo resource!";
	}
	
}
