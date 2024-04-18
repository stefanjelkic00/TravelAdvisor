package com.diplomski.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Recenzija;

@Repository
public interface RecenzijaRepository extends JpaRepository<Recenzija, Integer>{

	Recenzija findById(int id);
	
	List<Recenzija> findAllByDestinacijaId(int destinacija_id);
}
