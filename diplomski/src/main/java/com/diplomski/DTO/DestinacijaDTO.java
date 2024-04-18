package com.diplomski.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinacijaDTO {

	private float longitude;
	private float latitude;
	private String adresa;
	private String naziv;
	private String opis; 
	private List<String> slikeDestinacije;

}
