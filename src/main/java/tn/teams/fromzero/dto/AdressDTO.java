package tn.teams.fromzero.dto;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.fromzero.entities.Adress;
import tn.teams.fromzero.entities.Employee;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class AdressDTO {
	private Long id;
	
	@NotEmpty(message ="street doit etre not empty")
	private String street;
	
    @Size(max = 50 , min = 5)
    @Min(value= 1, message="housenumber doit etre sup a 1")
    @Max(value= 1000, message="housenumber doit etre inf a 1000")

	private String housenumber;
    
    @NotBlank
	private String zipcode; 
   private EmployeeDTO employeetdo;
    
    public static AdressDTO FromEntity(Adress adress) {
    	return AdressDTO.builder()
    			.id(adress.getId())
    			.street(adress.getStreet())
    			.housenumber(adress.getHousenumber())
    			.zipcode(adress.getZipcode())
    			//.employeetdo(EmployeeDTO.fromEntity(adress.getEmployee()))
    			.build();	
    }
    public static Adress toEntity(AdressDTO dto) {
    	return Adress.builder()
    			.id(dto.getId())
    			.street(dto.getStreet())
    			.housenumber(dto.getHousenumber())
    			.zipcode(dto.getZipcode())
    			//.employee(EmployeeDTO.toEntity(dto.getEmployeetdo()))
    			.build();	
    
    }
    
	
	
}
