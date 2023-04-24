package tn.teams.fromzero.services;

import tn.teams.fromzero.dto.EmployeeDTO;

import java.util.List;

public interface ServiceEmployee {

 
    void delete(Long id);
    EmployeeDTO findById(Long id);
    List<EmployeeDTO> findAllEmployees();
    Integer countEmployeesByAge(Integer age);
	EmployeeDTO save(EmployeeDTO dto);
	void addMissiontoEmployee (String nameMission , String nameEmployee);
	EmployeeDTO getemloyeebynameemail(String fullname,String email);
	List<EmployeeDTO> listeremplbydept(String namedpt);
	List<EmployeeDTO> listeremplbyfulsorting(String fulname);
	List<EmployeeDTO> findAllpageEmployees();
}
