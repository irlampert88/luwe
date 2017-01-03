package com.corp.luwe.domain.factory;

import com.corp.luwe.domain.dto.ElectionDto;
import com.corp.luwe.domain.entity.ElectedOption;
import com.corp.luwe.domain.entity.Election;

/**
 * @author Ivan Lampert
 */
public final class ElectionDtoFactory {

	private ElectionDtoFactory() {
	}
	
	public static ElectionDto createFrom(Election election) {
		ElectedOption winner = election.getOptionWinner();
		
		return new ElectionDto(election.getId(), 
				               election.getDateFormatted(), 
				               winner.getRestaurant().getNick(), 
				               winner.getElectors().size(), 
				               election.getTotalVotes());
	}
	
}
