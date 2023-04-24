package tn.teams.fromzero.dto;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.teams.fromzero.entities.Mission;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissionDtoSavemany {
	private Long id;
	private String name;
	private String period;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datedebut;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date datefin;
	//private List<Long> employeId;
	 private Set<Long> employeesdto;

	public static MissionDtoSavemany fromentitie(Mission mission) {
		MissionDtoSavemany missiondto = new MissionDtoSavemany();
		BeanUtils.copyProperties(mission, missiondto);

		return missiondto;
	}

	public static Mission toentitie(MissionDtoSavemany dto) {
		Mission mission = new Mission();
		BeanUtils.copyProperties(dto, mission);
		return mission;

	}
}
