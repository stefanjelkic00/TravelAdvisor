package com.diplomski.serviceImplementation;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.diplomski.DTO.RecenzijaDTO;
import com.diplomski.models.Destinacija;
import com.diplomski.models.Korisnik;
import com.diplomski.models.Recenzija;
import com.diplomski.repository.DestinacijaRepository;
import com.diplomski.repository.KorisnikRepository;
import com.diplomski.repository.RecenzijaRepository;
import com.diplomski.service.RecenzijaService;

@Service
public class RecenzijaServiceImplementation implements RecenzijaService{
	
	@Autowired
	private RecenzijaRepository recenzijaRepo;
	
	@Autowired
	private DestinacijaRepository destinacijaRepo;
	
	@Autowired
	private KorisnikRepository korisnikRepo;

	@Override
	public List<Recenzija> getAllRecenzije() {
		return recenzijaRepo.findAll();
	}

	@Override
	public List<Recenzija> getAllRecenzijeByDestinacija(int destinacija_id) {
		
		return recenzijaRepo.findAllByDestinacijaId(destinacija_id);
 
	}

	@Override
	public Recenzija createRecenzija(RecenzijaDTO recenzijaDTO) {
		try {
			String email = SecurityContextHolder.getContext().getAuthentication().getName();
			Korisnik korisnik = korisnikRepo.findByEmail(email);
			Destinacija destinacija = destinacijaRepo.findById(recenzijaDTO.getDestinacijaID());
			System.out.println(korisnik.getEmail());
			Recenzija recenzija = new Recenzija(recenzijaDTO.getOcena(), recenzijaDTO.getKomentar() ,korisnik, destinacija);
			recenzija.setBrojSvidjanja(0);
			recenzija.setBrojNesvidjanja(0);
			recenzija.setDatum(LocalDateTime.now());
			
			int brojRecenzija = destinacija.getRecenzija().size();

			Double prosecnaOcenaDestinacije  = destinacija.getProsecnaOcena();
			if (prosecnaOcenaDestinacije == null) {
				prosecnaOcenaDestinacije = 0.0 ; 
			}
			double ukupanZbirOcena = prosecnaOcenaDestinacije * brojRecenzija;
			double prosecnaOcena = (ukupanZbirOcena + recenzija.getOcena()) / (brojRecenzija+1) ;
			recenzija.getDestinacija().setProsecnaOcena(prosecnaOcena);
			return recenzijaRepo.save(recenzija);
		}
		catch(Exception ex){
			return null;
		}
	
	}

	@Override
	public Recenzija deleteRecenzija(int id) {
		Recenzija recenzija = recenzijaRepo.findById(id);
		if(recenzija != null) {
			System.out.println("Nesto ");
			recenzijaRepo.deleteById(id);
			return recenzija;
		}
		
		return null;	
	}
	

}
