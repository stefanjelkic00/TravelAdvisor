package com.diplomski.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class SlikaDestinacije {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name= "putanja",nullable=false)
	private String putanja;
	
	@ManyToOne
	@JoinColumn(name = "destinacija" , nullable = false )
	private Destinacija destinacija;

	public SlikaDestinacije(String putanja, Destinacija destinacija) {
		super();
		this.putanja = putanja;
		this.destinacija = destinacija;
	}
	
	
}
