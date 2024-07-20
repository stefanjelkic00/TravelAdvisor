package com.diplomski.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.DTO.RestoranDTO;
import com.diplomski.DTO.UpdateRestoranDTO;
import com.diplomski.enums.TipRestorana;
import com.diplomski.models.Restoran;
import com.diplomski.models.SlikaDestinacije;
import com.diplomski.repository.RestoranRepository;
import com.diplomski.repository.SlikaDestinacijeRepository;
import com.diplomski.service.RestoranService;

@Service
public class RestoranServiceImplementation implements RestoranService{
	
	@Autowired
	private RestoranRepository restoranRepo;
	
	@Autowired
	private SlikaDestinacijeRepository slikaDestinacijeRepo;

	@Override
	public List<Restoran> getAllRestorani() {
		
		return restoranRepo.findAll();
	}
	@Override
	public List<Restoran> getAllRestoranByQuery(String query) {
		List<Restoran> restorani = restoranRepo.findAll().stream().filter(s -> s.getNaziv().toLowerCase()
				.contains(query.toLowerCase().trim()) || s.getAdresa().toLowerCase().contains(query.toLowerCase().trim()) || 
				s.getTipRestorana().toString().toLowerCase().contains(query.toLowerCase().trim())).toList();
		return restorani;
	}

	@Override
	public Restoran getRestoranById(int id) {
	
		return restoranRepo.findById(id);
	}

	@Override
	public Restoran createRestoran(RestoranDTO restoranDTO) {
		Restoran restoran = new Restoran(restoranDTO.getLongitude(),restoranDTO.getLatitude(),restoranDTO.getAdresa(),
				restoranDTO.getNaziv(),restoranDTO.getOpis(),TipRestorana.valueOf(restoranDTO.getTipRestorana()));
		
		restoran = restoranRepo.save(restoran);
		restoran.setSlikaDestinacije(new ArrayList<>());
		// Prvo smo morali da kreiramo restoran da bih smo mogli da mu dodamo slike 
		// if nam sluzi u slucaju da se desila neka greska prilikom kreiranja restorana da nam onemoguci dodavanje slika onda
		if(restoran != null) {
			for(String slika : restoranDTO.getSlikeDestinacije()) {
				SlikaDestinacije slikaDestinacije = new SlikaDestinacije(slika,restoran);
				slikaDestinacijeRepo.save(slikaDestinacije);
				restoran.getSlikaDestinacije().add(slikaDestinacije);
			}
		}
		return restoran;
	}

	@Override
	public Restoran updateRestoran(UpdateRestoranDTO restoranDTO) {
		
		Restoran restoran = restoranRepo.findById(restoranDTO.getId());
		
		restoran.setAdresa(restoranDTO.getAdresa());
		restoran.setLongitude(restoranDTO.getLongitude());
		restoran.setLatitude(restoranDTO.getLatitude());
		restoran.setNaziv(restoranDTO.getNaziv());
		restoran.setOpis(restoranDTO.getOpis());
		restoran.setTipRestorana(TipRestorana.valueOf(restoranDTO.getTipRestorana()));
		
		return restoranRepo.save(restoran);
	}

	@Override
	public Restoran deleteRestoran(int id) {
		Restoran restoran = restoranRepo.findById(id);
		if(restoran != null) {
			restoranRepo.delete(restoran);
			return restoran;
		}
		
		return null;
	}

}
