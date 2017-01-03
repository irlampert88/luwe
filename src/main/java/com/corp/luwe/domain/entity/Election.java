package com.corp.luwe.domain.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.corp.luwe.domain.util.Timer;
import com.corp.luwe.integration.repository.entity.converters.LocalDateConverter;

/**
 * @author Ivan Lampert
 */
@Entity
@Table(name = "tb_election")
public final class Election 
	extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id;
	private LocalDate date;
	private Set<ElectedOption> electedOptions;

	protected Election() {
	}
	
	public Election(LocalDate date) {
		this.date = date;
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
	
	@Convert(converter = LocalDateConverter.class)
	@Column(nullable = false)
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ELECTION_ID")
	public Set<ElectedOption> getElectedOptions() {
		return (electedOptions != null ? electedOptions : (electedOptions = new HashSet<>()));
	}
	
	public void setElectedOptions(Set<ElectedOption> electedOptions) {
		this.electedOptions = electedOptions;
	}

	@Transient
	public final String getDateFormatted() {
		return Timer.formatDateToString(getDate()) + " " + Timer.dayOfWeekName(getDate());
	}
	
	@Transient
	public ElectedOption getOptionWinner() {
		Optional<ElectedOption> winner = getElectedOptions().stream()
			.max((o1, o2) -> Integer.compare(o1.getElectors().size(), o2.getElectors().size()));
		
		return (winner.isPresent() ? winner.get() : fakeNullElectedOption());
	}
	
	@Transient
	public Restaurant getRestaurantWinner() {
		return getOptionWinner().getRestaurant();
	}
	
	private ElectedOption fakeNullElectedOption() {
		return new ElectedOption(new Restaurant("Nenhum"));
	}

	@Transient
	public Integer getTotalVotes() {
		return getElectedOptions().stream()
			.mapToInt(option -> option.getElectors().size()).sum();
	}

	public void addNewOption(Restaurant restaurant, Set<Elector> electors) {
		ElectedOption newOption = new ElectedOption(restaurant);
		newOption.setElectors(electors);
		getElectedOptions().add(newOption);
	}

	@Transient
	public boolean isOfToday() {
		return (getDate().isEqual(LocalDate.now()));
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((electedOptions == null) ? 0 : electedOptions.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Election other = (Election) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (electedOptions == null) {
			if (other.electedOptions != null)
				return false;
		} else if (!electedOptions.equals(other.electedOptions))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public final String toString() {
		return "Election [id=" + id + ", date=" + date + ", electedOptions=" + electedOptions + "]";
	}

}
