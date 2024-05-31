package com.diplomski.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Destinacija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "longitude",nullable=false)
	private float longitude;
	
	@Column(name= "latitude",nullable=false)
	private float latitude;
	
	@Column(name= "adresa",nullable=false)
	private String adresa;
	
	@Column(name= "naziv",nullable=false)
	private String naziv;
	
	private String opis; 
	
	private Double prosecnaOcena;
	
	@JsonIgnore
	@OneToMany(mappedBy = "destinacija" , fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
	private List<Recenzija> recenzija;
	
	
	@OneToMany(mappedBy = "destinacija" )
	private List<SlikaDestinacije> slikaDestinacije;

	public Destinacija(float longitude, float latitude, String adresa, String naziv, String opis) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.adresa = adresa;
		this.naziv = naziv;
		this.opis = opis;
	}
	
	
	
}
