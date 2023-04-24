package tn.teams.fromzero.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.teams.fromzero.entities.Department;
@Repository
public interface DepartementReposetory extends JpaRepository<Department, Long> {

}
