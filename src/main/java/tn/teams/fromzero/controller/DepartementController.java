package tn.teams.fromzero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.teams.fromzero.ServicesImpl.ServiceDepartementImpl;
import tn.teams.fromzero.dto.DepartementDTO;
import tn.teams.fromzero.services.Departementservice;

@RestController
@RequestMapping("/api/v1/departements")
@CrossOrigin("http://localhost:4200")
public class DepartementController {
	@Autowired
  private Departementservice serdep ;
//  
//  @GetMapping("/listdepartements")
//  public List<DepartementDTO> afficher() {
//	  
//  return serdep.findAllDepartement();
//		  
//}
    @PostMapping("/save")
	public DepartementDTO save(@RequestBody DepartementDTO dto) {
    	
		return serdep.save(dto);
	}
    @DeleteMapping("/delet/{id}")
	public void delete(@PathVariable Long id) {
		serdep.delete(id);
	}
    @GetMapping("/getbyid/{id}")
	public DepartementDTO findById(@PathVariable Long id) {
		return serdep.findById(id);
	}
    @GetMapping("/getall")
	public List<DepartementDTO> findAllDepartement() {
		return serdep.findAllDepartement();
	}
	
}