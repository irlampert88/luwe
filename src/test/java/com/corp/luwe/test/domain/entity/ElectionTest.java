package com.corp.luwe.test.domain.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.corp.luwe.domain.entity.Election;
import com.corp.luwe.test.domain.shared.AbstractElectionTest;


public class ElectionTest 
	extends AbstractElectionTest {

	@Test
	public void testElectionIsOfTodayWhenDateIsYestarday() {
		assertFalse(fakeElectionOfYestarday().isOfToday());
	}

	@Test
	public void testElectionIsOfTodayWhenDateIsToday() {
		assertTrue(fakeElectionOfToday().isOfToday());
	}
	
	@Test
	public void testOptionWinner() {
		assertEquals("Restaurant B", fakeElectionWithElectedOptions().getOptionWinner().getRestaurant().getNick());
	}
	
	@Test
	public void testReturnFakeWinnerWhenDoesntHaveOptions() {
		assertEquals("Nenhum", new Election(LocalDate.now()).getOptionWinner().getRestaurant().getNick());
	}
	
	@Test
	public void testTotalVotesCounterIsRight() {
		assertTrue(fakeElectionWithElectedOptions().getTotalVotes() == 9);
	}

}
