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
import com.diplomski.DTO.UpdateZnamenitostDTO;
import com.diplomski.DTO.ZnamenitostDTO;
import com.diplomski.models.Znamenitost;
import com.diplomski.service.ZnamenitostService;



@RestController
@RequestMapping("/api/znamenitost")
public class ZnamenitostController {
	
	
	@Autowired
	private ZnamenitostService znamenitostService;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Znamenitost> createZnamenitost(@RequestBody ZnamenitostDTO znamenitostDTO){
		Znamenitost znamenitost = znamenitostService.createZnamenitost(znamenitostDTO);
		if(znamenitost == null) {
			return new ResponseEntity<Znamenitost>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Znamenitost>(znamenitost , HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<Znamenitost> updateZnamenitost(@RequestBody UpdateZnamenitostDTO updateZnamenitostDTO){
		Znamenitost znamenitost = znamenitostService.updateZnamenitost(updateZnamenitostDTO);
		if(znamenitost == null) {
			return new ResponseEntity<Znamenitost>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Znamenitost>(znamenitost , HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Znamenitost> deleteZnamenitost(@PathVariable int id){
		
		Znamenitost znamenitost = znamenitostService.deleteZnamenitost(id);

		if(znamenitost == null) {
			return new ResponseEntity<Znamenitost>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Znamenitost>(HttpStatus.OK);
		
		
		
	}
}
