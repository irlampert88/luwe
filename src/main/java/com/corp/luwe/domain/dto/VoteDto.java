package com.corp.luwe.domain.dto;

import com.corp.luwe.domain.entity.Elector;
import com.corp.luwe.domain.entity.Restaurant;

/**
 * @author irlampert1
 */
public class VoteDto {

	private Long electionid;
	private Restaurant restaurant;
	private Elector elector;
	
	public VoteDto() {
	}

	public VoteDto(Long electionid, Restaurant restaurant, Elector elector) {
		this.electionid = electionid;
		this.restaurant = restaurant;
		this.elector = elector;
	}

	public Long getElectionid() {
		return electionid;
	}
	
	public void setElectionid(Long electionid) {
		this.electionid = electionid;
	}
	
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Elector getElector() {
		return elector;
	}

	public void setElector(Elector elector) {
		this.elector = elector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((electionid == null) ? 0 : electionid.hashCode());
		result = prime * result + ((elector == null) ? 0 : elector.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteDto other = (VoteDto) obj;
		if (electionid == null) {
			if (other.electionid != null)
				return false;
		} else if (!electionid.equals(other.electionid))
			return false;
		if (elector == null) {
			if (other.elector != null)
				return false;
		} else if (!elector.equals(other.elector))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VoteDto [electionid=" + electionid + ", restaurant=" + restaurant + ", elector=" + elector + "]";
	}

}
