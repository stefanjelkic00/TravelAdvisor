package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Smestaj;

@Repository
public interface SmestajRepository extends JpaRepository<Smestaj, Integer>{

	Smestaj findById(int id);

}
