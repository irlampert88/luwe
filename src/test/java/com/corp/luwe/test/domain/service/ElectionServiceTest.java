package com.corp.luwe.test.domain.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.corp.luwe.domain.entity.Election;
import com.corp.luwe.domain.repository.ElectionRepository;
import com.corp.luwe.domain.service.impl.ElectionServiceImpl;
import com.corp.luwe.test.domain.shared.AbstractElectionTest;

@RunWith(MockitoJUnitRunner.class)
public class ElectionServiceTest 
	extends AbstractElectionTest {

	@Mock
	private ElectionRepository electionRepository;
	
	@InjectMocks
	private ElectionServiceImpl electionService;
	
	@Test
	public void testElectorCanVoteTodayWhenDontVotedToday() {
		when(electionRepository.electorVotesTodayCount(10L)).thenReturn(0);
		assertThat(electionService.electorCanVoteToday(fakeElector()), is(Boolean.TRUE));	
	}
	
	@Test
	public void testElectorCantVoteTodayWhenAlreadyVotedToday() {
		when(electionRepository.electorVotesTodayCount(10L)).thenReturn(1);
		assertThat(electionService.electorCanVoteToday(fakeElector()), is(Boolean.FALSE));	
	}

	@Test
	public void testIfExistElectionTodayReturnTrue() {
		List<Election> electionOfToday = Arrays.asList(fakeElectionOfToday());
		when(electionRepository.findByDateIsToday()).thenReturn(electionOfToday);
		assertThat(electionService.alreadyExistsElectionToday(), is(Boolean.TRUE));
	}
	
	@Test
	public void testIfDontExistElectionTodayReturnFalse() {
		when(electionRepository.findByDateIsToday()).thenReturn(Collections.emptyList());
		assertThat(electionService.alreadyExistsElectionToday(), is(Boolean.FALSE));
	}
	
}
