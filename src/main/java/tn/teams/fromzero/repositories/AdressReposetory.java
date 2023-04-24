package tn.teams.fromzero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.teams.fromzero.entities.Adress;
public interface AdressReposetory extends JpaRepository<Adress, Long>  {
	// reposotery : persistence BD appeler les CRUD
   // communication avec la BD JpaRepository (CRUD) 
	
}
