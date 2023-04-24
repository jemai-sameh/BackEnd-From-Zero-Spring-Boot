package tn.teams.fromzero.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tn.teams.fromzero.dto.EmployeeDTO;
import tn.teams.fromzero.services.ServiceEmployee;

@RestController 
@RequestMapping("api/v1/employee")
@CrossOrigin("http://localhost:4200")

public class EmployeeController {
private ServiceEmployee serviceemployee;

@PostMapping("/save")
public EmployeeDTO save(@RequestBody EmployeeDTO dtomp) {
	
	return serviceemployee.save(dtomp);
}


@DeleteMapping("/delete/{id}")
public void delete(@PathVariable Long id ) {
	serviceemployee.delete(id);
}

@GetMapping("/findbyid/{id}")
public EmployeeDTO findById(@PathVariable Long id) {
	return serviceemployee.findById(id);
}


@GetMapping("/lister")
public List<EmployeeDTO> findAllEmployees() {
	return serviceemployee.findAllEmployees();
}

@GetMapping("/liste-age/{age}")
public Integer countEmployeesByAge(@PathVariable Integer age) {
	return serviceemployee.countEmployeesByAge(age);
}


public EmployeeController(ServiceEmployee serviceemployee) {
	super();
	this.serviceemployee = serviceemployee;
}
@PostMapping("/getempolyeebyfullname-email")
public EmployeeDTO getemloyeebynameemail(@RequestBody Viewempl viewempl) {
	//System.err.println(viewempl.fullname  + "******************");
	
	return serviceemployee.getemloyeebynameemail(viewempl.getFullname(), viewempl.getEmail());
}

@GetMapping("/getempolyeebydpt/{namedpt}")
public List<EmployeeDTO> listeremplbydept(@PathVariable String namedpt) {
	return serviceemployee.listeremplbydept("%"+namedpt+"%");
}
@GetMapping("/getempolyeebysorting/{fullname}")
public List<EmployeeDTO> listerempbysorting(@PathVariable String fullname) {
	return serviceemployee.listeremplbyfulsorting("%"+fullname+"%");
}



@GetMapping("/getempolyeebypage")
public List<EmployeeDTO> listerempbypagination() {
	return serviceemployee.findAllpageEmployees();
}
}
class Viewempl{
	
	/*public Viewempl(String fullname, String email) {
		super();
		this.fullname = fullname;
		this.email = email;
	}*/
	private String fullname;
	private String email;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
