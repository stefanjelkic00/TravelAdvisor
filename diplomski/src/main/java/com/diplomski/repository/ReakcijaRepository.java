package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Reakcija;

@Repository
public interface ReakcijaRepository extends JpaRepository<Reakcija, Integer>{

	Reakcija findById(int id);
}
