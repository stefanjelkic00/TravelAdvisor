package com.diplomski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.diplomski.models.SlikaDestinacije;

@Repository
public interface SlikaDestinacijeRepository extends JpaRepository<SlikaDestinacije, Integer>{
	SlikaDestinacije findById(int id);

}
