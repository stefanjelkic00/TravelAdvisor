package com.diplomski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diplomski.DTO.ReakcijaDTO;
import com.diplomski.DTO.UpdateReakcijaDTO;
import com.diplomski.models.Reakcija;
import com.diplomski.service.ReakcijaService;

@RestController
@RequestMapping("/api/reakcija")
public class ReakcijaController {

	@Autowired
	ReakcijaService reakcijaService;
	
	@GetMapping
	public ResponseEntity<List<Reakcija>> getAllReakcije(){
		return new ResponseEntity<List<Reakcija>>(reakcijaService.getAllReakcije(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Reakcija> getReakcijaById(@PathVariable int id){
		Reakcija reakcija = reakcijaService.getReakcijaById(id);
		if(reakcija == null) {
			return new ResponseEntity<Reakcija>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Reakcija>(reakcija , HttpStatus.OK);
	}
	
	@GetMapping("/recenzija/{id}")
	public ResponseEntity<Reakcija> getReakcijaByRecenzijaAndKorisnik(@PathVariable int id){
		Reakcija reakcija = reakcijaService.getReakcijaByRecenzijaAndKorisnik(id);
		if(reakcija == null) {
			return new ResponseEntity<Reakcija>(HttpStatus.OK);
		}
		return new ResponseEntity<Reakcija>(reakcija , HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Reakcija> createReakcija(@RequestBody ReakcijaDTO reakcijaDTO){
		Reakcija reakcija = reakcijaService.createReakcija(reakcijaDTO);
		if(reakcija == null) {
			return new ResponseEntity<Reakcija>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Reakcija>(reakcija , HttpStatus.CREATED);
	}
	
	
	
	@PutMapping
	public ResponseEntity<Reakcija> updateReakcija(@RequestBody UpdateReakcijaDTO updateReakcijaDTO){
		Reakcija reakcija = reakcijaService.updateReakcija(updateReakcijaDTO);
		if(reakcija == null) {
			return new ResponseEntity<Reakcija>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Reakcija>(reakcija , HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Reakcija> deleteReakcija(@PathVariable int id){
		
		reakcijaService.deleteReakcija(id);

		
		
		return new ResponseEntity<Reakcija>(HttpStatus.OK);
		
		
		
	}
}
