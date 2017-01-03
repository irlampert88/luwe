package com.corp.luwe.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ivan Lampert
 */
@Entity
@Table(name = "tb_restaurant")
public final class Restaurant
	extends AbstractEntity<Long> {

	private static final long serialVersionUID = 1L;

	private Long id; 
	private String nick;
	private String wifiPassword;
	private String observation;
	private Boolean canRepeatOnWeek;
	
	protected Restaurant() {
	}

	public Restaurant(String nick) {
		this.nick = nick;
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

	@Column
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@Column
	public String getWifiPassword() {
		return wifiPassword;
	}
	
	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}
	
	@Column
	public String getObservation() {
		return observation;
	}
	
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	@Column
	public Boolean getCanRepeatOnWeek() {
		return (canRepeatOnWeek != null && canRepeatOnWeek);
	}
	
	public void setCanRepeatOnWeek(Boolean canRepeatOnWeek) {
		this.canRepeatOnWeek = canRepeatOnWeek;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canRepeatOnWeek == null) ? 0 : canRepeatOnWeek.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((observation == null) ? 0 : observation.hashCode());
		result = prime * result + ((wifiPassword == null) ? 0 : wifiPassword.hashCode());
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
		Restaurant other = (Restaurant) obj;
		if (canRepeatOnWeek == null) {
			if (other.canRepeatOnWeek != null)
				return false;
		} else if (!canRepeatOnWeek.equals(other.canRepeatOnWeek))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (observation == null) {
			if (other.observation != null)
				return false;
		} else if (!observation.equals(other.observation))
			return false;
		if (wifiPassword == null) {
			if (other.wifiPassword != null)
				return false;
		} else if (!wifiPassword.equals(other.wifiPassword))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", nick=" + nick + ", wifiPassword=" + wifiPassword + ", observation="
				+ observation + ", canRepeatOnWeek=" + canRepeatOnWeek + "]";
	}

}
