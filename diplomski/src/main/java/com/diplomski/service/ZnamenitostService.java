package com.diplomski.service;

import java.util.List;

import com.diplomski.DTO.UpdateZnamenitostDTO;
import com.diplomski.DTO.ZnamenitostDTO;
import com.diplomski.models.Znamenitost;

public interface ZnamenitostService {
	List<Znamenitost> getAllZnamenitosti();
	
	Znamenitost getZnamenitostById(int id);
	
	Znamenitost createZnamenitost(ZnamenitostDTO znamenitostDTO);
	
	Znamenitost updateZnamenitost(UpdateZnamenitostDTO znamenitostDTO);
	
	Znamenitost deleteZnamenitost(int id);
}
