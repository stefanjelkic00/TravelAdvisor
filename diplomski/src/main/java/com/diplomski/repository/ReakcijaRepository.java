package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diplomski.models.Korisnik;
import com.diplomski.models.Reakcija;
import com.diplomski.models.Recenzija;

@Repository
public interface ReakcijaRepository extends JpaRepository<Reakcija, Integer>{

	Reakcija findById(int id);
	 
	Reakcija findByRecenzijaAndKorisnik(Recenzija recenzija , Korisnik korisnik);
}
