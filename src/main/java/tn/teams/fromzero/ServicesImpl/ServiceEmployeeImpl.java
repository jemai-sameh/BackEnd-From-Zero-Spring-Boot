package tn.teams.fromzero.ServicesImpl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import tn.teams.fromzero.dto.EmployeeDTO;
import tn.teams.fromzero.entities.Department;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.entities.Mission;
import tn.teams.fromzero.repositories.DepartementReposetory;
import tn.teams.fromzero.repositories.EmployeeRepository;
import tn.teams.fromzero.repositories.MissionRepository;
import tn.teams.fromzero.services.ServiceEmployee;
import tn.teams.fromzero.validations.ObjectsValidator;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceEmployeeImpl implements ServiceEmployee {


    private final EmployeeRepository employeeRepository;        // injection des dependences injecterun classe dans un autre
    private final DepartementReposetory departementRepository;
    private final MissionRepository missionRepository;


    /* public ServiceEmployeeImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    */

    private final   ObjectsValidator<EmployeeDTO> objectsValidator;


    @Override
    public EmployeeDTO save(EmployeeDTO dto) {
    	
        objectsValidator.validate(dto);
        // controle  validation 
       // Optional<Department> optionaldepartement =departementRepository.findById(id)  ;
        
        Employee employee = EmployeeDTO.toEntity(dto);
        
        Employee savedEmployee= employeeRepository.save(employee); //employee: entity
        
        return EmployeeDTO.fromEntity(savedEmployee); // entity to DTO
    }

    @Override
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new EntityNotFoundException(id+" not found"));
        employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDTO findById(Long id) {
        return employeeRepository.findById(id).map(EmployeeDTO::fromEntity)
        		//map:  
                .orElseThrow(() -> new EntityNotFoundException("No Employee was found with the provided ID"));
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        return employeeRepository.findAll()
                .stream() // parcour la liste 
                .map(EmployeeDTO::fromEntity) // convertion liste 
                .collect(Collectors.toList()); // retour liste
    }

    @Override
    public Integer countEmployeesByAge(Integer age) {
        return employeeRepository.countEmployeesByAge(age);
    }

	@Override
	public void addMissiontoEmployee(String nameMission, String nameEmployee) {
		// TODO Auto-generated method stub
		
		
		
		Employee employee = employeeRepository.findByFullName(nameEmployee);
		Mission mission = missionRepository.findByName(nameMission);
		employee.getMissions().add(mission);
		employeeRepository.save(employee);
		
	}

	@Override
	public EmployeeDTO getemloyeebynameemail(String fullname, String email) {
		// TODO Auto-generated method stub
		Employee eml =employeeRepository.getFullNameEmail(fullname, email);
		
				return EmployeeDTO.fromEntity(eml);
	}

	@Override
	public List<EmployeeDTO> listeremplbydept(String namedpt) {
		List<Employee> empls=employeeRepository.getEmployeeByIdNamedpt(namedpt);
		List<EmployeeDTO> empdto=empls.stream().map(emp->EmployeeDTO.fromEntity(emp)).collect(Collectors.toList());
		return empdto;
	}

	@Override
	public List<EmployeeDTO> listeremplbyfulsorting(String fulname) {
		List<Employee> empls=employeeRepository.findByfullNameAndSort(fulname, Sort.by("fullName").descending());
		List<EmployeeDTO> empdto=empls.stream().map(emp->EmployeeDTO.fromEntity(emp)).collect(Collectors.toList());
		return empdto;
	}

	@Override
	public List<EmployeeDTO> findAllpageEmployees() {
		int page = 0;
	    int size = 2;

	    Pageable pageable = PageRequest.of(page, size);
	    List<Employee> empls = employeeRepository.findAllWithPagination(pageable).getContent();
	    List<EmployeeDTO> empdto=empls.stream().map(emp->EmployeeDTO.fromEntity(emp)).collect(Collectors.toList());
		return empdto;
	}
	
	
	//Function<Integer, Integer> nom= (a,b)->a+b;
	 
/*	public static int somme(int a, int b) {
		  return a + b;
		}
		
		(int a, int b) -> a + b*/
}
