package com.corp.luwe.domain.service;

import java.util.List;

import com.corp.luwe.domain.dto.ElectedDto;
import com.corp.luwe.domain.dto.ElectionDto;
import com.corp.luwe.domain.dto.VoteDto;
import com.corp.luwe.domain.entity.Elector;
import com.corp.luwe.domain.entity.Restaurant;

/**
 * @author Ivan Lampert
 */
public interface ElectionService {

	public Iterable<ElectionDto> allElectionsDto();

	public boolean electorCanVoteToday(Elector elector);

	public void newVote(VoteDto vote);

	public List<ElectedDto> getElectedsFromElection(Long id);

	public boolean canVoteInRestaurantThisWeek(Restaurant restaurant);

	public boolean alreadyExistsElectionToday();
	
}
