package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.Znamenitost;

@Repository
public interface ZnamenitostRepository extends JpaRepository<Znamenitost, Integer>{

	Znamenitost findById(int id);

}
