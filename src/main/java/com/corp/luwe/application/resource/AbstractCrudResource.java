package com.corp.luwe.application.resource;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.corp.luwe.domain.entity.AbstractEntity;

/**
 * @author Ivan Lampert
 */
public abstract class AbstractCrudResource<ENTITY extends AbstractEntity<PK>, PK extends Serializable> {

//	private static final Logger LOGGER = LoggerFactory.getLogger(??Resource.class);
	
	private final CrudRepository<ENTITY, PK> repository;
	
	public AbstractCrudResource(CrudRepository<ENTITY, PK> repository) {
		this.repository = repository;
	}
	
	@RequestMapping(method=RequestMethod.POST, 
					consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE) 
	public final ResponseEntity<ENTITY> save(@RequestBody ENTITY entity){
		repository.save(entity);		
		return new ResponseEntity<ENTITY>(HttpStatus.OK);
	}	
	
	@RequestMapping(method=RequestMethod.PUT, 
					consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<ENTITY> update(@RequestBody ENTITY entity){
		repository.save(entity);
		return new ResponseEntity<ENTITY>(HttpStatus.OK);
	}	

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public final ResponseEntity<ENTITY> delete(@PathVariable("id") PK id){
		repository.delete(id);
		return new ResponseEntity<ENTITY>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final ENTITY findById(@PathVariable PK id){
		return repository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final Iterable<ENTITY> findAll(){
		return repository.findAll();		
	}
	
}
