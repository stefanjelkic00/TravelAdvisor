package com.diplomski.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KorisnikDTO {

	
	private String ime; 
	
	private String prezime;
	
	private String email;
	
	private String password;
	
}
