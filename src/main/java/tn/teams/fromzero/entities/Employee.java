package tn.teams.fromzero.entities;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.ManyToAny;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
///@Table(name="emp")
public class Employee {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id ;

    @Column(name = "nom_prenom", nullable = false)
    private String fullName ;
    private Integer age ;
//fullNameemail
    @Column(unique = true)
    private String email ;
    @OneToOne(mappedBy = "employee")
    private Adress adress;
    @ManyToOne
    @JoinColumn(name="fkdepartmentId")
    private Department department;
   @ManyToMany(mappedBy = "employees")
   
  
  
    private Set<Mission> missions;
    
    
}
