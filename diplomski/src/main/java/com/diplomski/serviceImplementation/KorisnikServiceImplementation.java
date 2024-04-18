package com.diplomski.serviceImplementation;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diplomski.DTO.KorisnikDTO;
import com.diplomski.enums.Uloga;
import com.diplomski.models.Korisnik;
import com.diplomski.repository.KorisnikRepository;
import com.diplomski.service.KorisnikService;


@Service
public class KorisnikServiceImplementation implements KorisnikService , UserDetailsService{

	@Autowired
	private KorisnikRepository korisnikRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Korisnik register(KorisnikDTO korisnikDTO) {
		Korisnik korisnik = new Korisnik(korisnikDTO.getIme() , korisnikDTO.getPrezime() 
				, korisnikDTO.getEmail());
		korisnik.setPassword(passwordEncoder.encode(korisnikDTO.getPassword()));
		korisnik.setUloga(Uloga.ROLE_KORISNIK);
		
		return korisnikRepo.save(korisnik);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikRepo.findByEmail(email);
		if(korisnik == null) {
			throw new UsernameNotFoundException("Nije nasao korisnika sa datim Emailom");
		}
		
			Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
		    authority.add(new SimpleGrantedAuthority(korisnik.getUloga().toString()));
		    	return new User(korisnik.getEmail(),korisnik.getPassword(), authority);
		
		
	}

}
