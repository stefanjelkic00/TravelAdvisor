package com.diplomski.models;

import com.diplomski.enums.TipSmestaja;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
public class Smestaj extends Destinacija{
	
	@Enumerated(EnumType.STRING)
	@Column(name= "tip_smestaja", nullable = false)
	private TipSmestaja tipSmestaja;

	public Smestaj(float longitude, float latitude, String adresa, String naziv, String opis, TipSmestaja tipSmestaja) {
		super(longitude, latitude, adresa, naziv, opis);
		this.tipSmestaja = tipSmestaja;
	}
	
	
	

}
