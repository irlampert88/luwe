package com.corp.luwe.domain.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ivan Lampert
 */
@Entity
@Table(name = "tb_elected_option")
public final class ElectedOption 
	extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Restaurant restaurant;
	private Set<Elector> electors;
	
	public ElectedOption() {
	}

	public ElectedOption(Restaurant restaurant) {
		this.restaurant = restaurant;
		this.electors = new HashSet<>();
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", nullable = false)
	public Restaurant getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "TB_OPTION_ELECTOR",
			   joinColumns = { @JoinColumn(name = "OPTION_ID") },
			   inverseJoinColumns = { @JoinColumn(name = "ELECTOR_ID") } )
	public Set<Elector> getElectors() {
		return (electors == null ? electors = new HashSet<>() : electors);
	}
	
	public void setElectors(Set<Elector> electors) {
		this.electors = electors;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((electors == null) ? 0 : electors.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((restaurant == null) ? 0 : restaurant.hashCode());
		return result;
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ElectedOption other = (ElectedOption) obj;
		if (electors == null) {
			if (other.electors != null)
				return false;
		} else if (!electors.equals(other.electors))
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
		return true;
	}

	@Override
	public final String toString() {
		return "ElectedOption [id=" + id + ", restaurant=" + restaurant + ", electors=" + electors + "]";
	}
	
}
