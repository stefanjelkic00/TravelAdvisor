package com.diplomski.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RecenzijaDTO {
	
	private int ocena;
	
	private String komentar;
	
	private int korisnikID;
	
	private int destinacijaID; 
}
