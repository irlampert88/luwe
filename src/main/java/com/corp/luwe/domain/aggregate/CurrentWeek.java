package com.corp.luwe.domain.aggregate;

import java.time.LocalDate;

/**
 * @author Ivan Lampert
 */
public class CurrentWeek {

	private final LocalDate startOfWeek;
	private final LocalDate endOfWeek;
	
	public CurrentWeek() {
		LocalDate today = LocalDate.now();
		
		int month = today.getMonth().getValue();
		int year = today.getYear();
		int dayOfMonth = today.getDayOfMonth();
		int dayOfWeek = today.getDayOfWeek().getValue();
		
		this.startOfWeek = LocalDate.of(year, month, (dayOfMonth - dayOfWeek));
		this.endOfWeek = LocalDate.of(year, month, (dayOfMonth + (6 - dayOfWeek)));
	}
	
	public LocalDate getStartOfWeek() {
		return startOfWeek;
	}
	
	public LocalDate getEndOfWeek() {
		return endOfWeek;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endOfWeek == null) ? 0 : endOfWeek.hashCode());
		result = prime * result + ((startOfWeek == null) ? 0 : startOfWeek.hashCode());
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
		CurrentWeek other = (CurrentWeek) obj;
		if (endOfWeek == null) {
			if (other.endOfWeek != null)
				return false;
		} else if (!endOfWeek.equals(other.endOfWeek))
			return false;
		if (startOfWeek == null) {
			if (other.startOfWeek != null)
				return false;
		} else if (!startOfWeek.equals(other.startOfWeek))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CurrentWeek [startOfWeek=" + startOfWeek + ", endOfWeek=" + endOfWeek + "]";
	}

}
