package com.diplomski.models;
import java.util.List;

import com.diplomski.enums.Uloga;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Korisnik {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "ime",nullable=false)
	private String ime; 
	
	@Column(name= "prezime",nullable=false)
	private String prezime;
	
	@Enumerated(EnumType.STRING)
	@Column(name= "uloga",nullable=false)
	private Uloga uloga;
	
	@Column(name= "email",nullable=false, unique=true)
	private String email;
	
	@Column(name= "password",nullable=false)
	private String password;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "korisnik")
	private List<Recenzija> recenzije;
	
	@JsonIgnore
	@OneToMany(mappedBy = "korisnik")
	private List<Reakcija> svidjanjeRecenzije;

	public Korisnik(String ime, String prezime, String email) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
	}
	
	
	
}
