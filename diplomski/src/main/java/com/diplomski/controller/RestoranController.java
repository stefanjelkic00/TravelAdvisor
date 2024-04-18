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
import com.diplomski.DTO.RestoranDTO;
import com.diplomski.DTO.UpdateRestoranDTO;
import com.diplomski.models.Restoran;
import com.diplomski.service.RestoranService;

@RestController
@RequestMapping("/api/restoran")
public class RestoranController {

	@Autowired
	private RestoranService restoranService;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<Restoran> createRestoran(@RequestBody RestoranDTO restoranDTO){
		Restoran restoran = restoranService.createRestoran(restoranDTO);
		if(restoran == null) {
			return new ResponseEntity<Restoran>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Restoran>(restoran , HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public ResponseEntity<Restoran> updateRestoran(@RequestBody UpdateRestoranDTO updateRestoranDTO){
		Restoran restoran = restoranService.updateRestoran(updateRestoranDTO);
		if(restoran == null) {
			return new ResponseEntity<Restoran>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Restoran>(restoran , HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Restoran> deleteRestoran(@PathVariable int id){
		
		Restoran restoran = restoranService.deleteRestoran(id);

		if(restoran == null) {
			return new ResponseEntity<Restoran>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Restoran>(HttpStatus.OK);
		
		
		
	}
	
}
