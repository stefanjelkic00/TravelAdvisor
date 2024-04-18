package com.diplomski.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDestinacijaDTO {
	
	private int id;
	private float longitude;
	private float latitude;
	private String adresa;
	private String naziv;
	private String opis; 
	
}
