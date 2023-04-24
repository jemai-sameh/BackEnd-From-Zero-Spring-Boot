package tn.teams.fromzero.services;

import java.util.List;


import tn.teams.fromzero.dto.DepartementDTO;

public interface Departementservice {
	    public DepartementDTO save(DepartementDTO dto);
	    void delete(Long id);
	    DepartementDTO findById(Long id);
	    List<DepartementDTO> findAllDepartement();

}
