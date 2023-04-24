package tn.teams.fromzero.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.entities.Mission;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	@Query("select e from Employee e where e.fullName like %:x% and e.email like %:y%")
	public Employee getFullNameEmail(@Param("x") String nom,@Param("y") String email );
	
	@Query("select e from Employee e where e.department.name like :im")
	public List<Employee> getEmployeeByIdNamedpt(@Param("im") String name);
	//***
	@Query("SELECT t FROM Employee t WHERE t.fullName LIKE %?1%")
	  List<Employee> findByEmployeeLike(String title);
	//**
	@Query("SELECT t FROM Employee t WHERE t.fullName LIKE %:im%")
	  List<Employee> findByEmployeLike(@Param("im") String title);
	
	@Query("select count(emp) from Employee emp where emp.age=:age")
    Integer countEmployeesByAge( @Param("age") Integer age);
    Employee findByFullName(String name);
    // requete sorting
    @Query("SELECT t FROM Employee t WHERE t.fullName LIKE %?1%")
    List<Employee> findByfullNameAndSort(String fullname, Sort sort);
   //page
    @Query("SELECT t FROM Employee t")
    Page<Employee> findAllWithPagination(Pageable pageable);

	public Optional<Employee> findById(Long id);
}
