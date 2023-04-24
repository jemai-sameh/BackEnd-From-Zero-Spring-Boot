package tn.teams.fromzero.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.teams.fromzero.dto.AdressDTO;
import tn.teams.fromzero.services.AdressService;

@RestController 
@RequestMapping("Api/v1/adress")

public class AdressController {
private AdressService serviceadress;

@PostMapping("/save/{id}")
public ResponseEntity<AdressDTO> save(@RequestBody AdressDTO dto, @PathVariable Long id) {// T nom classe
	 // gere les status  de la response 
	AdressDTO adressdtosaved = serviceadress.save(dto, id);
	return new ResponseEntity<AdressDTO>(adressdtosaved, HttpStatus.CREATED);
	
	
	
}
@DeleteMapping("/delete/{id}")
public void delete(@PathVariable Long id ) {
	serviceadress.delete(id);
}
@GetMapping("/findbyid/{id}")
public AdressDTO findById(@PathVariable Long id) {
	return serviceadress.findById(id);
}
@GetMapping("/lister")
public List<AdressDTO> findAllAdress() {
	return serviceadress.findAllAdress();
}
public AdressController(AdressService adressservice) {
	super();
	this.serviceadress = adressservice;
}

}