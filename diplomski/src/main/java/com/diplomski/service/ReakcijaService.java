package com.diplomski.service;

import java.util.List;

import com.diplomski.DTO.ReakcijaDTO;
import com.diplomski.DTO.UpdateReakcijaDTO;
import com.diplomski.models.Reakcija;


public interface ReakcijaService {

	List<Reakcija> getAllReakcije();
	
	Reakcija getReakcijaById(int id); 
	
	Reakcija getReakcijaByRecenzijaAndKorisnik(int id);
	
	Reakcija createReakcija(ReakcijaDTO reakcijaDTO);
	
	void deleteReakcija(int id);
	
	Reakcija updateReakcija(UpdateReakcijaDTO reakcijaDTO);
	
}
