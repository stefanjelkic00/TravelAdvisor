package com.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diplomski.DTO.SmestajDTO;
import com.diplomski.DTO.UpdateSmestajDTO;
import com.diplomski.models.Smestaj;
import com.diplomski.service.SmestajService;





@RestController
@RequestMapping("/api/smestaj")
public class SmestajController {
	@Autowired
	private SmestajService smestajService;
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Smestaj> createSmestaj(@RequestBody SmestajDTO smestajDTO){
		Smestaj smestaj = smestajService.createSmestaj(smestajDTO);
		if(smestaj == null) {
			return new ResponseEntity<Smestaj>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Smestaj>(smestaj , HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<Smestaj> updateSmestaj(@RequestBody UpdateSmestajDTO updateSmestajDTO){
		Smestaj smestaj = smestajService.updateSmestaj(updateSmestajDTO);
		if(smestaj == null) {
			return new ResponseEntity<Smestaj>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Smestaj>(smestaj , HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Smestaj> deleteSmestaj(@PathVariable int id){
		
		Smestaj smestaj = smestajService.deleteSmestaj(id);

		if(smestaj == null) {
			return new ResponseEntity<Smestaj>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Smestaj>(HttpStatus.OK);
		
		
		
	}
}
