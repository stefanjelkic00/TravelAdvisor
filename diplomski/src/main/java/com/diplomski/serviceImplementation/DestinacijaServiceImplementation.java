package com.diplomski.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diplomski.models.Destinacija;
import com.diplomski.repository.DestinacijaRepository;
import com.diplomski.service.DestinacijaService;

@Service
public class DestinacijaServiceImplementation implements DestinacijaService{
	
	
	@Autowired
	private DestinacijaRepository destinacijaRepo;

	@Override
	public List<Destinacija> getAllDestinacije() {

		return destinacijaRepo.findAll();
	}

	@Override
	public Destinacija getDestinacijaById(int id) {
		
		return destinacijaRepo.findById(id);
	}

}
