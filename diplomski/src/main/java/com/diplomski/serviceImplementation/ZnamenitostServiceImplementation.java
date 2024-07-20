package com.diplomski.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.DTO.UpdateZnamenitostDTO;
import com.diplomski.DTO.ZnamenitostDTO;
import com.diplomski.enums.TipZnamenitosti;
import com.diplomski.models.SlikaDestinacije;
import com.diplomski.models.Znamenitost;
import com.diplomski.repository.SlikaDestinacijeRepository;
import com.diplomski.repository.ZnamenitostRepository;
import com.diplomski.service.ZnamenitostService;

@Service
public class ZnamenitostServiceImplementation implements ZnamenitostService{

	@Autowired
	private ZnamenitostRepository znamenitostRepo;
	
	@Autowired
	private SlikaDestinacijeRepository slikaDestinacijeRepo;
	
	
	
	@Override
	public List<Znamenitost> getAllZnamenitosti() {
		
		return znamenitostRepo.findAll();
		
	}
	
	@Override
	public List<Znamenitost> getAllZnamenitostByQuery(String query) {
		List<Znamenitost> znamenitosti = znamenitostRepo.findAll().stream().filter(s -> s.getNaziv().toLowerCase()
				.contains(query.toLowerCase().trim()) || s.getAdresa().toLowerCase().contains(query.toLowerCase().trim()) || 
				s.getTipZnamenitosti().toString().toLowerCase().contains(query.toLowerCase().trim())).toList();
		return znamenitosti;
	}

	@Override
	public Znamenitost getZnamenitostById(int id) {
		
		return znamenitostRepo.findById(id);
	}

	@Override
	public Znamenitost createZnamenitost(ZnamenitostDTO znamenitostDTO) {
		Znamenitost znamenitost = new Znamenitost(znamenitostDTO.getLongitude(),znamenitostDTO.getLatitude(),znamenitostDTO.getAdresa(),
				znamenitostDTO.getNaziv(),znamenitostDTO.getOpis(),TipZnamenitosti.valueOf(znamenitostDTO.getTipZnamenitosti()));
		
		znamenitost = znamenitostRepo.save(znamenitost);
		znamenitost.setSlikaDestinacije(new ArrayList<>());
		// Prvo smo morali da kreiramo znamenitost da bih smo mogli da mu dodamo slike 
		// if nam sluzi u slucaju da se desila neka greska prilikom kreiranja znamenitosti da nam onemoguci dodavanje slika onda
		if(znamenitost != null) {
			for(String slika : znamenitostDTO.getSlikeDestinacije()) {
				SlikaDestinacije slikaDestinacije = new SlikaDestinacije(slika,znamenitost);
				slikaDestinacijeRepo.save(slikaDestinacije);
				znamenitost.getSlikaDestinacije().add(slikaDestinacije);
			}
		}
		return znamenitost;
		
	}

	@Override
	public Znamenitost updateZnamenitost(UpdateZnamenitostDTO znamenitostDTO) {
		Znamenitost znamenitost = znamenitostRepo.findById(znamenitostDTO.getId());
		
		znamenitost.setAdresa(znamenitostDTO.getAdresa());
		znamenitost.setLongitude(znamenitostDTO.getLongitude());
		znamenitost.setLatitude(znamenitostDTO.getLatitude());
		znamenitost.setNaziv(znamenitostDTO.getNaziv());
		znamenitost.setOpis(znamenitostDTO.getOpis());
		znamenitost.setTipZnamenitosti(TipZnamenitosti.valueOf(znamenitostDTO.getTipZnamenitosti()));
		
		return znamenitostRepo.save(znamenitost);
	}

	@Override
	public Znamenitost deleteZnamenitost(int id) {
		Znamenitost znamenitost = znamenitostRepo.findById(id);
		if(znamenitost != null) {
			znamenitostRepo.delete(znamenitost);
			return znamenitost;
		}
		
		return null;				
	}

}
