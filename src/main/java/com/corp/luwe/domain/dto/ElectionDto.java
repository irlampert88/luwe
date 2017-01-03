package com.corp.luwe.domain.dto;

/**
 * @author irlampert1
 */
public class ElectionDto {

	private final Long id;
	private final String date; 
	private final String restaurant;
	private final Integer restaurantVotes;
	private final Integer totalVotes;

	public ElectionDto(Long id, String date, String restaurant, Integer restaurantVotes, Integer totalVotes) {
		this.id = id;
		this.date = date;
		this.restaurant = restaurant;
		this.restaurantVotes = restaurantVotes;
		this.totalVotes = totalVotes;
	}

	public Long getId() {
		return id;
	}
	
	public String getDate() {
		return date;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public Integer getRestaurantVotes() {
		return restaurantVotes;
	}

	public Integer getTotalVotes() {
		return totalVotes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		result = prime * result + ((restaurantVotes == null) ? 0 : restaurantVotes.hashCode());
		result = prime * result + ((totalVotes == null) ? 0 : totalVotes.hashCode());
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
		ElectionDto other = (ElectionDto) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (restaurant == null) {
			if (other.restaurant != null)
				return false;
		} else if (!restaurant.equals(other.restaurant))
			return false;
		if (restaurantVotes == null) {
			if (other.restaurantVotes != null)
				return false;
		} else if (!restaurantVotes.equals(other.restaurantVotes))
			return false;
		if (totalVotes == null) {
			if (other.totalVotes != null)
				return false;
		} else if (!totalVotes.equals(other.totalVotes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ElectionDto [id=" + id + ", date=" + date + ", restaurant=" + restaurant
				+ ", restaurantVotes=" + restaurantVotes + ", totalVotes=" + totalVotes + "]";
	}

}
