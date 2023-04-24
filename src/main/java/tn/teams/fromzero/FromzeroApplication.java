package tn.teams.fromzero;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tn.teams.fromzero.ServicesImpl.ServiceDepartementImpl;
import tn.teams.fromzero.dto.DepartementDTO;
import tn.teams.fromzero.services.Departementservice;
import tn.teams.fromzero.services.MissionService;

@SpringBootApplication
public class FromzeroApplication  {

	public static void main(String[] args) {
		
		SpringApplication.run(FromzeroApplication.class, args);
		
	}
    /*@Bean // executer au demrrage
	CommandLineRunner commandRunner(MissionService missionService ) {
    	
    	
	
	return args->{ 
		missionService.addMissiontoEmplyee("jamel", "Mis");
		//Stream.of("Dept3").forEach(name->{
			//DepartementDTO depdto = new DepartementDTO();
			//depdto.setName("dept4");
			//deptserv.save(depdto);
			
		//});
	};
		
	}*/
	@Autowired
	private MissionService missionService;

//	@Override
//	public void run(String... args) throws Exception {
//		 missionService.addMissiontoEmplyee("jamel", "Mis");
//		
//	}
	
	

}
