package tn.teams.fromzero.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.teams.fromzero.entities.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {

	Mission findByName(String name);
	
	 @Query("SELECT t FROM Mission t WHERE t.datedebut BETWEEN ?1 AND ?2")
	    List<Mission> findByDateBetween(Date start, Date end);
	    
	
}
