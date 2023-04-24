package tn.teams.fromzero.ServicesImpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.teams.fromzero.dto.DepartementDTO;
import tn.teams.fromzero.dto.EmployeeDTO;
import tn.teams.fromzero.entities.Department;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.repositories.DepartementReposetory;
import tn.teams.fromzero.services.Departementservice;
import tn.teams.fromzero.validations.ObjectsValidator;
@Service
public class ServiceDepartementImpl implements Departementservice {
	@Autowired
	
    private DepartementReposetory departementReposetory;
	
	@Autowired
	ObjectsValidator<DepartementDTO> x;
	@Override
	public DepartementDTO save(DepartementDTO dto) {
		// TODO Auto-generated method stub
		
		//x.validate(dto);
		Department department= DepartementDTO.Toentity(dto);
		
		Department departementsd = departementReposetory.save(department);
		
		
		return DepartementDTO.FromEntity(departementsd);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 Department department = departementReposetory.findById(id).orElseThrow(()->new EntityNotFoundException(id+" not found"));
		 departementReposetory.deleteById(id);
		
	}

	@Override
	public DepartementDTO findById(Long id) {
		// TODO Auto-generated method stub+-+
		return departementReposetory.findById(id).map(DepartementDTO :: FromEntity)
        		//map: 
                .orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided ID"));
	}

	@Override
	public List<DepartementDTO> findAllDepartement() {
		// TODO Auto-generated method stub+
		 return departementReposetory.findAll()
	                .stream() // parcour la liste 
	                .map(DepartementDTO :: FromEntity) // convertion liste 
	                .collect(Collectors.toList());
		
	}
 
}
