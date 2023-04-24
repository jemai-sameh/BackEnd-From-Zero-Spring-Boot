package tn.teams.fromzero.ServicesImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import tn.teams.fromzero.dto.MissionDTO;
import tn.teams.fromzero.dto.MissionDtoSavemany;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.entities.Mission;
import tn.teams.fromzero.exceptions.MissionNotFoundExcep;
import tn.teams.fromzero.repositories.EmployeeRepository;
import tn.teams.fromzero.repositories.MissionRepository;
import tn.teams.fromzero.services.MissionService;


@Service
@AllArgsConstructor
public class ServiceMissionImpl implements MissionService {
	
	private  MissionRepository missionRepository ;
	private EmployeeRepository employeeRepository;
	
	
	
	
	@Override
	public MissionDtoSavemany saveMission (MissionDtoSavemany missionDtoSavemany) {
		Mission mission=MissionDtoSavemany.toentitie(missionDtoSavemany);
		/*for(Long id:missionDtoSavemany.getEmployeId()) {
			Employee employee= new Employee();
			employee.setId(id);
			mission.addempl(employee);
		}*/
	Set<Long> strEmps= missionDtoSavemany.getEmployeesdto();
        Set<Employee> emps = new HashSet<>();
        strEmps.forEach(ids -> {
        	Employee enmp = employeeRepository.findById(ids)
                    .orElseThrow(() -> new RuntimeException("not found."));
            emps.add(enmp);

            
    });
        mission.setEmployees(emps);

		missionRepository.save(mission);
		MissionDtoSavemany MissionDTOsaved=MissionDtoSavemany.fromentitie(mission);
			return MissionDTOsaved;
		}
	
	/*public MissionDTO save(MissionDTO dto) {
		Mission mission = MissionDTO.toentitie(dto);
		Mission missionsaved = missionRepository.save(mission);
		
		
		return MissionDTO.fromentitie(missionsaved);
		
	}*/

	@Override
	public void delete(Long id) throws MissionNotFoundExcep {
		
		Mission mission = missionRepository.findById(id)
				.orElseThrow(()-> new MissionNotFoundExcep("MissionNotFound"));
		
		missionRepository.deleteById(id);
		
	}

	@Override
	public MissionDTO findById(Long id) throws MissionNotFoundExcep {
		Mission mission = missionRepository.findById(id)
				.orElseThrow(()-> new MissionNotFoundExcep("MissionNotFound"));
		
		return MissionDTO.fromentitie(mission) ;
	}

	@Override
	public List<MissionDTO> findAllMission() {
		List<Mission> missions = missionRepository.findAll();
		List<MissionDTO> missionDTOs = missions.stream().map(mission->MissionDTO.fromentitie(mission))
				.collect(Collectors.toList()) ;
		return missionDTOs;
	}

	@Override
	public void addMissiontoEmplyee(String nameEmployee, String nameMission) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findByFullName(nameEmployee);
		Mission mission = missionRepository.findByName(nameMission);
		mission.getEmployees().add(employee);
		System.err.println(mission.getName());
		//System.out.println(mission.getEmployees().get(0).getFullName());
	}

	@Override
	public MissionDTO save(MissionDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MissionDTO> findBybetweendate(Date start, Date end) {
		List<Mission> mission= missionRepository.findByDateBetween(start, end);
		List<MissionDTO> listmissiondto =mission.stream().map(mes-> MissionDTO.fromentitie(mes)).collect(Collectors.toList());
		return listmissiondto;
	}
	

}
