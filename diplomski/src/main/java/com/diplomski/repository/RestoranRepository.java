package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Restoran;


@Repository
public interface RestoranRepository extends JpaRepository<Restoran, Integer>{
	
	Restoran findById(int id);

}
