package com.corp.luwe.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.corp.luwe.domain.entity.Election;

/**
 * @author Ivan Lampert
 */
@Repository
public interface ElectionRepository 
	extends CrudRepository<Election, Long> {

	@Query("SELECT E FROM Election E WHERE date = current_date")
	public List<Election> findByDateIsToday();
	
	@Query("SELECT E FROM Election E ORDER BY date DESC")
	public List<Election> findOrderByDateDesc();

	@Query(nativeQuery = true,
		   value = " SELECT COUNT(1) FROM tb_election t " +
			       " JOIN tb_elected_option eo ON t.id = eo.election_id " +
			       " JOIN tb_option_elector oe ON eo.id = oe.option_id " +
			       " JOIN tb_elector el ON oe.elector_id = el.id " +
			       " WHERE t.date = current_date " +
			       " AND el.id = :id")
	public int electorVotesTodayCount(@Param("id") Long electorId);

	@Query(" SELECT E FROM Election E " +                        
		   " WHERE E.date between ?1 AND ?2")
	public List<Election> findWinnerBetweenDates(LocalDate startOfWeek, LocalDate endOfWeek);
	
}
