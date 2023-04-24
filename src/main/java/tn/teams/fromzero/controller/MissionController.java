package tn.teams.fromzero.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.teams.fromzero.dto.EmplMissDto;
import tn.teams.fromzero.dto.MissionDTO;
import tn.teams.fromzero.dto.MissionDtoSavemany;
import tn.teams.fromzero.dto.ViewDate;
import tn.teams.fromzero.entities.Employee;
import tn.teams.fromzero.entities.Mission;
import tn.teams.fromzero.exceptions.MissionNotFoundExcep;
import tn.teams.fromzero.repositories.EmployeeRepository;
import tn.teams.fromzero.repositories.MissionRepository;
import tn.teams.fromzero.services.MissionService;

@RestController
@RequestMapping("/api/v1/mission")
@CrossOrigin(origins = "http://localhost:4200")
public class MissionController {
	@Autowired
	private MissionService missionService;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private MissionRepository missionRepository;

	@PostMapping("/save")
	public MissionDTO save(@RequestBody MissionDTO dto) {
	
		return missionService.save(dto);
	}
	@PostMapping("/savemiss")
	public MissionDtoSavemany save(@RequestBody MissionDtoSavemany dto) {
	
		return missionService.saveMission(dto);
	}
	public void delete(Long id) throws MissionNotFoundExcep {
		missionService.delete(id);
	}

	public MissionDTO findById(Long id) throws MissionNotFoundExcep {
		return missionService.findById(id);
	}

	public List<MissionDTO> findAllMission() {
		return missionService.findAllMission();
	}
@PostMapping("/missiontoemployee")
public MissionDtoSavemany saveMission (@RequestBody MissionDtoSavemany missionDtoSavemany)
	
{
return missionService.saveMission(missionDtoSavemany);
		
		//missionService.addMissiontoEmplyee( e.nameEmployee, e.nameMission);
	
	}
@PostMapping("/listemission")
	public  List<MissionDTO> listeempldate(@RequestBody ViewDate viewDate)
	{
	
	return missionService.findBybetweendate(viewDate.start, viewDate.end);
	
	}

}
