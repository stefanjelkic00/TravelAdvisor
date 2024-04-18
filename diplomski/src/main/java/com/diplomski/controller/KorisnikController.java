package com.diplomski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.diplomski.DTO.KorisnikDTO;
import com.diplomski.models.Korisnik;
import com.diplomski.service.KorisnikService;

@RestController
@RequestMapping("/api")
public class KorisnikController {
	
	@Autowired
    private KorisnikService korisnikService;

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password){
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(email, password);
        return new ResponseEntity<>(authenticationManager.authenticate(authenticationToken),HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<Korisnik> register(@Validated @RequestBody KorisnikDTO korisnikDto, BindingResult errors){
    	if (errors.hasErrors()) {
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Korisnik korisnik = korisnikService.register(korisnikDto);
        if(korisnik != null)
        	  return new ResponseEntity<>(korisnik, HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
}
