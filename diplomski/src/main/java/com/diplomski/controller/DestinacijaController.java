package com.diplomski.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.diplomski.models.Destinacija;
import com.diplomski.models.Restoran;
import com.diplomski.models.Smestaj;
import com.diplomski.models.Znamenitost;
import com.diplomski.service.DestinacijaService;
import com.diplomski.service.RestoranService;
import com.diplomski.service.SmestajService;
import com.diplomski.service.ZnamenitostService;

@RestController
@RequestMapping("/api/destinacija")
public class DestinacijaController {
	
	@Autowired
	private DestinacijaService destinacijaService;
	
	@Autowired
	private SmestajService smestajService;
	
	@Autowired
	private ZnamenitostService znamenitostService;
	
	@Autowired
	private RestoranService restoranService;
	
	
	@GetMapping
	public ResponseEntity<List<Destinacija>> getAllDestinacije(){
		return new ResponseEntity<List<Destinacija>>(destinacijaService.getAllDestinacije(),HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Destinacija> getDestinacijaById(@PathVariable int id){
		Destinacija destinacija = destinacijaService.getDestinacijaById(id);
		if(destinacija == null) {
			return new ResponseEntity<Destinacija>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Destinacija>(destinacija , HttpStatus.OK);
	}

	
	@GetMapping("/smestaj")
	public ResponseEntity<List<Smestaj>> getAllSmestaji(){
		return new ResponseEntity<List<Smestaj>>(smestajService.getAllSmestaji(),HttpStatus.OK);
	}
	
	@GetMapping("/smestajSearch")
	public ResponseEntity<List<Smestaj>> getAllSmestajiByQuery(@RequestParam String query){
		List<Smestaj> smestaji = smestajService.getAllSmestajByQuery(query);
		return new ResponseEntity<List<Smestaj>>(smestaji,HttpStatus.OK);
	}
	
	@GetMapping("/smestaj/{id}")
	public ResponseEntity<Smestaj> getSmestajById(@PathVariable int id){
		Smestaj smestaj = smestajService.getSmestajById(id);
		if(smestaj == null) {
			return new ResponseEntity<Smestaj>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Smestaj>(smestaj , HttpStatus.OK);
	}
	
	@GetMapping("/znamenitost")
	public ResponseEntity<List<Znamenitost>> getAllZnamenitosti(){
		return new ResponseEntity<List<Znamenitost>>(znamenitostService.getAllZnamenitosti(),HttpStatus.OK);
	}
	
	@GetMapping("/znamenitost/{id}")
	public ResponseEntity<Znamenitost> getZnamenitostById(@PathVariable int id){
		Znamenitost znamenitost = znamenitostService.getZnamenitostById(id);
		if(znamenitost == null) {
			return new ResponseEntity<Znamenitost>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Znamenitost>(znamenitost , HttpStatus.OK);
	}
	

	
	@GetMapping("/restoran")
	public ResponseEntity<List<Restoran>> getAllRestorani(){
		return new ResponseEntity<List<Restoran>>(restoranService.getAllRestorani(),HttpStatus.OK);
	}
	
	@GetMapping("/restoran/{id}")
	public ResponseEntity<Restoran> getRestoranById(@PathVariable int id){
		Restoran restoran = restoranService.getRestoranById(id);
		if(restoran == null) {
			return new ResponseEntity<Restoran>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Restoran>(restoran , HttpStatus.OK);
	}
	
}
