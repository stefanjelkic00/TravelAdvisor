package com.diplomski.service;

import java.util.List;

import com.diplomski.DTO.RecenzijaDTO;
import com.diplomski.models.Recenzija;

public interface RecenzijaService {
	
	List<Recenzija> getAllRecenzije();
	
	List<Recenzija> getAllRecenzijeByDestinacija(int destinacija_id);
	
	Recenzija createRecenzija(RecenzijaDTO recenzijaDTO);
	
	Recenzija deleteRecenzija(int id);
	
}
