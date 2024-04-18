package com.diplomski.service;

import java.util.List;

import com.diplomski.DTO.SmestajDTO;
import com.diplomski.DTO.UpdateSmestajDTO;
import com.diplomski.models.Smestaj;



public interface SmestajService {
	List<Smestaj> getAllSmestaji();
	
	Smestaj getSmestajById(int id);
	
	Smestaj createSmestaj(SmestajDTO smestajDTO);
	
	Smestaj updateSmestaj(UpdateSmestajDTO smestajDTO);
	
	Smestaj deleteSmestaj(int id);
}
