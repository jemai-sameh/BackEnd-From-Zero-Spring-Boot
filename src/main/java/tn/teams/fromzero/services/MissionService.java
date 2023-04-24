package tn.teams.fromzero.services;

import java.util.Date;
import java.util.List;

import tn.teams.fromzero.dto.MissionDTO;
import tn.teams.fromzero.dto.MissionDtoSavemany;
import tn.teams.fromzero.exceptions.MissionNotFoundExcep;



public interface MissionService {
	

	MissionDTO save(MissionDTO dto);
    void delete(Long id) throws MissionNotFoundExcep;
    MissionDTO findById(Long id) throws MissionNotFoundExcep;
    List<MissionDTO> findAllMission();
    void addMissiontoEmplyee(String nameEmployee, String nameMission);
	MissionDtoSavemany saveMission(MissionDtoSavemany missionDtoSavemany);
	List<MissionDTO> findBybetweendate(Date start,Date end);
}
