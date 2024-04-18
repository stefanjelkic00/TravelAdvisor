package com.diplomski.models;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Recenzija {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ocena" , nullable = false)
	private int ocena;
	
	@Column(name = "komentar" , nullable = true)
	private String komentar;
	
	@Column(name = "datum" , nullable = false)
	private LocalDateTime datum;
	
	@Column(name = "broj_svidjanja" , nullable = false)
	private int brojSvidjanja;
	
	@Column(name = "broj_nesvidjanja" , nullable = false)
	private int brojNesvidjanja;
	
	@ManyToOne
	@JoinColumn(name = "korisnik" , unique = true)
	private Korisnik korisnik;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "destinacija" , nullable = false)
	private Destinacija destinacija; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "recenzija")
	private List<Reakcija> svidjanjeRecenzije;

	public Recenzija(int ocena, String komentar, Korisnik korisnik, Destinacija destinacija) {
		super();
		this.ocena = ocena;
		this.komentar = komentar;
		this.korisnik = korisnik;
		this.destinacija = destinacija;
	}
	
	
	
}
