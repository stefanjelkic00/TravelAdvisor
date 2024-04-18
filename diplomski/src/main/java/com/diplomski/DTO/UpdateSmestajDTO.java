package com.diplomski.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSmestajDTO extends UpdateDestinacijaDTO{
	
	private String tipSmestaja;
	
}
