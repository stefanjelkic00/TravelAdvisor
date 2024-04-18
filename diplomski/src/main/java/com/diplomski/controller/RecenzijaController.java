package com.diplomski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diplomski.DTO.RecenzijaDTO;
import com.diplomski.models.Recenzija;
import com.diplomski.service.RecenzijaService;

@RestController
@RequestMapping("/api/recenzija")
public class RecenzijaController {

	@Autowired
	private RecenzijaService recenzijaService;
	
	@GetMapping
	public ResponseEntity<List<Recenzija>> getAllRecenzije(){
		return new ResponseEntity<List<Recenzija>>(recenzijaService.getAllRecenzije(),HttpStatus.OK);
	}
	
	@GetMapping("/destinacija/{destinacija_id}")
	public ResponseEntity<List<Recenzija>> getAllRecenzijeByDestinacija(@PathVariable int destinacija_id){
		return new ResponseEntity<List<Recenzija>>(recenzijaService.getAllRecenzijeByDestinacija(destinacija_id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Recenzija> createRecenzija(@RequestBody RecenzijaDTO recenzijaDTO){
		Recenzija recenzija = recenzijaService.createRecenzija(recenzijaDTO);
		if(recenzija == null) {
			return new ResponseEntity<Recenzija>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Recenzija>(recenzija , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Recenzija> deleteRecenzija(@PathVariable int id){
		
		Recenzija recenzija = recenzijaService.deleteRecenzija(id);

		if(recenzija == null) {
			return new ResponseEntity<Recenzija>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Recenzija>(HttpStatus.OK);
		
		
		
	}
}
