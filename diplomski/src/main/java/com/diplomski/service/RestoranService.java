package com.diplomski.service;

import java.util.List;

import com.diplomski.DTO.RestoranDTO;
import com.diplomski.DTO.UpdateRestoranDTO;
import com.diplomski.models.Restoran;

public interface RestoranService {

	List<Restoran> getAllRestorani();
	
	Restoran getRestoranById(int id);
	
	Restoran createRestoran(RestoranDTO restoranDTO);
	
	Restoran updateRestoran(UpdateRestoranDTO restoranDTO);
	
	Restoran deleteRestoran(int id);
} 
