package com.diplomski.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.DTO.ReakcijaDTO;
import com.diplomski.DTO.UpdateReakcijaDTO;
import com.diplomski.models.Korisnik;
import com.diplomski.models.Reakcija;
import com.diplomski.models.Recenzija;
import com.diplomski.repository.KorisnikRepository;
import com.diplomski.repository.ReakcijaRepository;
import com.diplomski.repository.RecenzijaRepository;
import com.diplomski.service.ReakcijaService;

@Service
public class ReakcijaServiceImplementation implements ReakcijaService {

	@Autowired
	private ReakcijaRepository reakcijaRepo;
	@Autowired
	private KorisnikRepository korisnikRepo;
	@Autowired
	private RecenzijaRepository recenzijaRepo;
	
	@Override
	public List<Reakcija> getAllReakcije() {
		List<Reakcija> reakcije = reakcijaRepo.findAll();
		return reakcije;
	}

	@Override
	public Reakcija getReakcijaById(int id) {
		
		Reakcija reakcija = reakcijaRepo.findById(id);
		
		return reakcija;
	}

	@Override
	public Reakcija createReakcija(ReakcijaDTO reakcijaDTO) {
		Korisnik korisnik = korisnikRepo.findById(reakcijaDTO.getKorisnik_id());
		Recenzija recenzija = recenzijaRepo.findById(reakcijaDTO.getRecenzija_id());
		Reakcija reakcija = new Reakcija(korisnik , recenzija , reakcijaDTO.isSvidjanje());
		
		if(reakcijaDTO.isSvidjanje() == true) { 
			int brojSvidjanja = reakcija.getRecenzija().getBrojSvidjanja();
			reakcija.getRecenzija().setBrojSvidjanja(brojSvidjanja + 1);
		}
		else {
			int brojNeSvidjanja = reakcija.getRecenzija().getBrojNesvidjanja();
			reakcija.getRecenzija().setBrojNesvidjanja(brojNeSvidjanja +1 );
		}
		
		return reakcijaRepo.save(reakcija);
		
	}

	@Override
	 public void  deleteReakcija(int id) {
		Reakcija reakcija = reakcijaRepo.findById(id);
		Recenzija recenzija = reakcija.getRecenzija();		
		
		if(reakcija.isSvidjanje() == true) { 
			int brojSvidjanja = reakcija.getRecenzija().getBrojSvidjanja();
			recenzija.setBrojSvidjanja(brojSvidjanja - 1);
		}
		else {
			int brojNeSvidjanja = reakcija.getRecenzija().getBrojNesvidjanja();
			recenzija.setBrojNesvidjanja(brojNeSvidjanja - 1 );
		}
		recenzijaRepo.save(recenzija);
		
		
		reakcijaRepo.delete(reakcija);
		
	}

	@Override
	public Reakcija updateReakcija(UpdateReakcijaDTO reakcijaDTO) {
		Reakcija reakcija = reakcijaRepo.findById(reakcijaDTO.getId());
		
		if(reakcija.isSvidjanje()== true) {
			reakcija.setSvidjanje(false);
			int brojSvidjanja = reakcija.getRecenzija().getBrojSvidjanja();
			reakcija.getRecenzija().setBrojSvidjanja(brojSvidjanja - 1);
			// u prethodnom delu smo brisali prosli lajk koji menjamo i sad treba ispod da dodamo dislajk da se sacuva 
			int brojNeSvidjanja = reakcija.getRecenzija().getBrojNesvidjanja();
			reakcija.getRecenzija().setBrojNesvidjanja(brojNeSvidjanja + 1 );
			
		}
		else {
			reakcija.setSvidjanje(true);
			int brojNeSvidjanja = reakcija.getRecenzija().getBrojNesvidjanja();
			reakcija.getRecenzija().setBrojNesvidjanja(brojNeSvidjanja - 1 );
			// u prethodnom delu smo brisali prosli dislajk koji menjamo i sad treba ispod da dodamo lajk da se sacuva 
			int brojSvidjanja = reakcija.getRecenzija().getBrojSvidjanja();
			reakcija.getRecenzija().setBrojSvidjanja(brojSvidjanja + 1);
		}
		
		
		return reakcijaRepo.save(reakcija);
	}

}
