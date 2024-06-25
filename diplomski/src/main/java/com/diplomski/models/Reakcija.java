package com.diplomski.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reakcija {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="korisnik")
	private Korisnik korisnik;
	
	@ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
	@JoinColumn(name="recenzija" , nullable= false)
	private Recenzija recenzija;
	
	@Column(nullable = false )
	private boolean svidjanje;

	public Reakcija(Korisnik korisnik, Recenzija recenzija, boolean svidjanje) {
		super();
		this.korisnik = korisnik;
		this.recenzija = recenzija;
		this.svidjanje = svidjanje;
	}
	
	
	
}
