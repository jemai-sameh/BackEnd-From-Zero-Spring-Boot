package tn.teams.fromzero.services;

import java.util.List;

import tn.teams.fromzero.dto.AdressDTO;

public interface AdressService {
	    AdressDTO save(AdressDTO dto, Long id);
	    void delete(Long id);
	    AdressDTO findById(Long id);
	    List<AdressDTO> findAllAdress();
	  

}
