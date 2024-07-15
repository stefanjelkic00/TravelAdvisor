package com.diplomski.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.DTO.SmestajDTO;
import com.diplomski.DTO.UpdateSmestajDTO;
import com.diplomski.enums.TipSmestaja;
import com.diplomski.models.SlikaDestinacije;
import com.diplomski.models.Smestaj;
import com.diplomski.repository.SlikaDestinacijeRepository;
import com.diplomski.repository.SmestajRepository;
import com.diplomski.service.SmestajService;

@Service
public class SmestajServiceImplementation implements SmestajService{

	
	@Autowired
	private SmestajRepository smestajRepo;
	
	@Autowired
	private SlikaDestinacijeRepository slikaDestinacijeRepo;
	
	@Override
	public List<Smestaj> getAllSmestaji() {
		
		return smestajRepo.findAll();
		
	}
	
	@Override
	public List<Smestaj> getAllSmestajByQuery(String query) {
		List<Smestaj> smestaji = smestajRepo.findAll().stream().filter(s -> s.getNaziv().toLowerCase()
				.contains(query.toLowerCase().trim()) || s.getAdresa().toLowerCase().contains(query.toLowerCase().trim()) || 
				s.getTipSmestaja().toString().toLowerCase().contains(query.toLowerCase().trim())).toList();
		return smestaji;
	}

	@Override
	public Smestaj getSmestajById(int id) {
		
		return smestajRepo.findById(id);
		
	}

	@Override
	public Smestaj createSmestaj(SmestajDTO smestajDTO) {
		Smestaj smestaj = new Smestaj(smestajDTO.getLongitude(),smestajDTO.getLatitude(),smestajDTO.getAdresa(),
				smestajDTO.getNaziv(),smestajDTO.getOpis(),TipSmestaja.valueOf(smestajDTO.getTipSmestaja()));
		
		smestaj = smestajRepo.save(smestaj);
		// Prvo smo morali da kreiramo smestaj da bih smo mogli da mu dodamo slike 
		// if nam sluzi u slucaju da se desila neka greska prilikom kreiranja smestaja da nam onemoguci dodavanje slika onda
		if(smestaj != null) {
			for(String slika : smestajDTO.getSlikeDestinacije()) {
				SlikaDestinacije slikaDestinacije = new SlikaDestinacije(slika,smestaj);
				slikaDestinacijeRepo.save(slikaDestinacije);
			}
		}
		return smestaj;
	}
	

	@Override
	public Smestaj updateSmestaj(UpdateSmestajDTO smestajDTO) {
		Smestaj smestaj = smestajRepo.findById(smestajDTO.getId());
		
		smestaj.setAdresa(smestajDTO.getAdresa());
		smestaj.setLongitude(smestajDTO.getLongitude());
		smestaj.setLatitude(smestajDTO.getLatitude());
		smestaj.setNaziv(smestajDTO.getNaziv());
		smestaj.setOpis(smestajDTO.getOpis());
		smestaj.setTipSmestaja(TipSmestaja.valueOf(smestajDTO.getTipSmestaja()));
		
		return smestajRepo.save(smestaj);
	}

	@Override
	public Smestaj deleteSmestaj(int id) {
		Smestaj smestaj = smestajRepo.findById(id);
		if(smestaj != null) {
			smestajRepo.delete(smestaj);
			return smestaj;
		}
		
		return null;		
	}

	

}
