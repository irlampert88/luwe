package com.corp.luwe.application.resource;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.corp.luwe.domain.dto.ElectedDto;
import com.corp.luwe.domain.dto.ElectionDto;
import com.corp.luwe.domain.dto.VoteDto;
import com.corp.luwe.domain.entity.Election;
import com.corp.luwe.domain.repository.ElectionRepository;
import com.corp.luwe.domain.service.ElectionService;

/**
 * @author Ivan Lampert
 */
@RestController
@RequestMapping(path = "/elections")
public class ElectionResource {

	private ElectionRepository repository;
	private ElectionService service;

	@Autowired
	public ElectionResource(ElectionService service, ElectionRepository repository) {
		this.service = service;
		this.repository = repository;
	}
	
	@RequestMapping(path = "/newvote", method = RequestMethod.POST, 
					consumes=MediaType.APPLICATION_JSON_VALUE, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public final ResponseEntity<Election> newVote(@RequestBody VoteDto vote) {
		if (!service.electorCanVoteToday(vote.getElector())) {
			return new ResponseEntity<Election>(HttpStatus.PRECONDITION_FAILED);
		}
		
		if (!service.canVoteInRestaurantThisWeek(vote.getRestaurant())) {
			return new ResponseEntity<Election>(HttpStatus.EXPECTATION_FAILED);
		}
		
		service.newVote(vote);
		return new ResponseEntity<Election>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public final ResponseEntity<Election> createElection() {
		if (service.alreadyExistsElectionToday()) {
			return new ResponseEntity<Election>(HttpStatus.PRECONDITION_FAILED);
		}
		
		repository.save(new Election(LocalDate.now()));
		return new ResponseEntity<Election>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public final Election findById(@PathVariable Long id){
		return repository.findOne(id);
	}

	@RequestMapping(value = "/electeds/{id}", method=RequestMethod.GET)
	public final List<ElectedDto> findElecteds(@PathVariable Long id){
		return service.getElectedsFromElection(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public final Iterable<ElectionDto> findAll(){
		return service.allElectionsDto();
	}

}
