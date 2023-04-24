package tn.teams.fromzero.ServicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import tn.teams.fromzero.dto.AdressDTO;
import tn.teams.fromzero.entities.Adress;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.repositories.AdressReposetory;
import tn.teams.fromzero.repositories.EmployeeRepository;
import tn.teams.fromzero.services.AdressService;
import tn.teams.fromzero.validations.ObjectsValidator;
@Service

@RequiredArgsConstructor         //injection dependences
public class ServiceAdressImpl implements AdressService{
	
	
	 private final AdressReposetory adressRepository;
	 private final EmployeeRepository employeeRepository;
	 // injection de dependence reposotery
	 private final   ObjectsValidator<AdressDTO> objectsValidator;
	@Override
	public AdressDTO save(AdressDTO dto, Long id) {
	
		// TODO Auto-generated method stub
		objectsValidator.validate(dto);
	    Employee employeeid = employeeRepository.findById(id).get(); 
		
		Adress adress= AdressDTO.toEntity(dto);
		adress.setEmployee(employeeid);
		Adress adressaved=adressRepository.save(adress);
		
		
		
		return AdressDTO.FromEntity(adressaved);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Adress> adress=adressRepository.findById(id);
		// recherche par id // optional : find null: pas de pb sinon execution
		if (adress.isPresent()) {
			adressRepository.deleteById(id);
		}
	}

	@Override
	public AdressDTO findById(Long id) {
		// TODO Auto-generated method stub
		Adress adress = adressRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No Adresse was found with the provided ID")); 
		return AdressDTO.FromEntity(adress);
	}

	@Override
	public List<AdressDTO> findAllAdress() {
		
		// TODO Auto-generated method stub
		List<Adress> adresss=adressRepository.findAll();
		List<AdressDTO> adressdtos= adresss.stream().map(adress->AdressDTO.FromEntity(adress)).collect(Collectors.toList());
	
		return adressdtos;
	}
	

}
