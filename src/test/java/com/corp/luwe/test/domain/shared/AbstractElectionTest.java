package com.corp.luwe.test.domain.shared;

import java.time.LocalDate;
import java.util.HashSet;

import com.corp.luwe.domain.entity.Election;
import com.corp.luwe.domain.entity.Elector;
import com.corp.luwe.domain.entity.Restaurant;

public class AbstractElectionTest {

	protected Election fakeElectionOfYestarday() {
		LocalDate now = LocalDate.now();
		LocalDate yestarday = LocalDate.of(now.getYear(), now.getMonthValue(), now.getDayOfMonth() - 1);
		Election electionOfYestarday = new Election(yestarday);
		return electionOfYestarday;
	}
	
	protected Election fakeElectionWithElectedOptions() {
		Election election = fakeElectionOfToday();

		election.addNewOption(fakeRestaurantA(), fakeElectorsForRestaurantA());
		election.addNewOption(fakeRestaurantB(), fakeElectorsForRestaurantB());
		election.addNewOption(fakeRestaurantC(), fakeElectorsForRestaurantC());
		return election;
	}

	protected Election fakeElectionOfToday() {
		return new Election(LocalDate.now());
	}
	
	protected Restaurant fakeRestaurantA() {
		return new Restaurant("Restaurant A");
	}

	protected HashSet<Elector> fakeElectorsForRestaurantA() {
		HashSet<Elector> electors = new HashSet<>();
		electors.add(new Elector("RestaurantA Elector FakeA"));
		electors.add(new Elector("RestaurantA Elector FakeB"));
		return electors;
	}

	protected Restaurant fakeRestaurantB() {
		return new Restaurant("Restaurant B");
	}

	protected HashSet<Elector> fakeElectorsForRestaurantB() {
		HashSet<Elector> electors = new HashSet<>();
		electors.add(new Elector("RestaurantB Elector FakeA"));
		electors.add(new Elector("RestaurantB Elector FakeB"));
		electors.add(new Elector("RestaurantB Elector FakeC"));
		electors.add(new Elector("RestaurantB Elector FakeD"));
		return electors;
	}
	
	protected Restaurant fakeRestaurantC() {
		return new Restaurant("Restaurant C");
	}
	
	protected HashSet<Elector> fakeElectorsForRestaurantC() {
		HashSet<Elector> electors = new HashSet<>();
		electors.add(new Elector("RestaurantC Elector FakeA"));
		electors.add(new Elector("RestaurantC Elector FakeB"));
		electors.add(new Elector("RestaurantC Elector FakeC"));
		return electors;
	}


	protected Elector fakeElector() {
		Elector joao = new Elector("João");
		joao.setId(10L);
		return joao;
	}
	
}
