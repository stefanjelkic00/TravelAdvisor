package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer>{
	
	
	Korisnik findById(int id);

	Korisnik findByEmail(String email);

}
