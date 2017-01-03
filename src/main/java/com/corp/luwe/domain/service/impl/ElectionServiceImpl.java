package com.corp.luwe.domain.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.luwe.domain.aggregate.CurrentWeek;
import com.corp.luwe.domain.dto.ElectedDto;
import com.corp.luwe.domain.dto.ElectionDto;
import com.corp.luwe.domain.dto.VoteDto;
import com.corp.luwe.domain.entity.ElectedOption;
import com.corp.luwe.domain.entity.Election;
import com.corp.luwe.domain.entity.Elector;
import com.corp.luwe.domain.entity.Restaurant;
import com.corp.luwe.domain.factory.ElectionDtoFactory;
import com.corp.luwe.domain.repository.ElectionRepository;
import com.corp.luwe.domain.service.ElectionService;

/**
 * @author Ivan Lampert
 */
@Service
public final class ElectionServiceImpl 
	extends AbstractCrudService<ElectionRepository, Election, Long>
		implements ElectionService {

	@Autowired
	public ElectionServiceImpl(ElectionRepository repository) {
		super(repository);
	}

	@Override
	public Iterable<ElectionDto> allElectionsDto() {
		List<ElectionDto> result = new ArrayList<>();
		
		getRepository().findOrderByDateDesc().forEach(election -> {
			result.add(ElectionDtoFactory.createFrom(election));
	    });
		
		return result;
	}

	@Override
	public boolean electorCanVoteToday(Elector elector) {
		return (getRepository().electorVotesTodayCount(elector.getId()) == 0);
	}

	@Override
	public void newVote(VoteDto vote) {
		Election election = getRepository().findOne(vote.getElectionid());
		
		if (electionDoesntHasAnOption(election)) {
			election.addNewOption(vote.getRestaurant(), new HashSet<>());
		}
		
		boolean hasRestaurantInOptions = false;
		for (ElectedOption option : election.getElectedOptions()) {
			if (option.getRestaurant().getId().equals(vote.getRestaurant().getId())) {
				hasRestaurantInOptions = true;
				option.getElectors().add(vote.getElector());
				break;
			}
		}

		if (!hasRestaurantInOptions) {
			election.addNewOption(vote.getRestaurant(), new HashSet<>(Arrays.asList(vote.getElector())));
		}

		getRepository().save(election);
	}

	private boolean electionDoesntHasAnOption(Election election) {
		return (election.getElectedOptions() == null || election.getElectedOptions().isEmpty());
	}

	@Override
	public List<ElectedDto> getElectedsFromElection(Long id) {
		Election election = getRepository().findOne(id);
		
		List<ElectedDto> result = new ArrayList<>();
		
		election.getElectedOptions().forEach(option -> {
			result.add(new ElectedDto(option.getRestaurant().getNick(), option.getElectors().size()));
		});
		
		return result;
	}

	@Override
	public boolean canVoteInRestaurantThisWeek(Restaurant restaurant) {
		if (!restaurant.getCanRepeatOnWeek()) {
			for (Election election : findAllElectionsFromThisWeek()) {
				if (isSameRestaurant(restaurant, election.getRestaurantWinner()) && !election.isOfToday()) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isSameRestaurant(Restaurant restaurant, Restaurant restaurantWinner) {
		return restaurant.getId().equals(restaurantWinner.getId());
	}

	private List<Election> findAllElectionsFromThisWeek() {
		CurrentWeek currentWeek = new CurrentWeek();
		
		return getRepository().findWinnerBetweenDates(currentWeek.getStartOfWeek(), currentWeek.getEndOfWeek());
	}

	@Override
	public boolean alreadyExistsElectionToday() {
		List<Election> electionsOfToday = getRepository().findByDateIsToday();
		return (electionsOfToday != null && !electionsOfToday.isEmpty());
	}

}
