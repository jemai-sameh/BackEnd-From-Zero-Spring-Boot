package tn.teams.fromzero.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Mission {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Long id; 
private String name;
private String period; 
@JsonFormat(pattern = "yyyy-MM-dd")
private Date datedebut;
@JsonFormat(pattern = "yyyy-MM-dd")
private Date datefin;
@ManyToMany
private Set<Employee> employees;
public void addempl(Employee employee) {
	if (this.employees ==null ) {this.employees = new HashSet<Employee>();}
	this.employees.add(employee);
	if ( employee.getMissions()==null )
	{employee.setMissions(new HashSet<Mission>());}
	 employee.getMissions().add(this);
}
}
