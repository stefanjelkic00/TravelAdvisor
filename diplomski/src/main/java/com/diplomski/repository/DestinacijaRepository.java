package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Destinacija;

@Repository
public interface DestinacijaRepository extends JpaRepository<Destinacija, Integer>{

	
	Destinacija findById(int id);

}
