package tn.teams.fromzero.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.BeanUtils;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import lombok.Getter;
import lombok.Setter;
import tn.teams.fromzero.entities.Department;

@Getter
@Setter

public class DepartementDTO {
	
	private Long id;
	@NotBlank
	private String name;
    public static DepartementDTO FromEntity(Department department) {
    	DepartementDTO departementDTO= new DepartementDTO();
    	BeanUtils.copyProperties(department, departementDTO); // créer un departementdto from entity
    	return departementDTO;
    }
    public static Department Toentity(DepartementDTO departementDTO) {
    	Department department= new Department();
    	BeanUtils.copyProperties(departementDTO, department);
    	return department;
    	
    }
	
	
}
