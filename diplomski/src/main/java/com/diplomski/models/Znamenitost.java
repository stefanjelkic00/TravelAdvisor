package com.diplomski.models;

import com.diplomski.enums.TipZnamenitosti;
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
public class Znamenitost extends Destinacija{

	@Enumerated(EnumType.STRING)
	@Column(name= "tip_znamenitosti", nullable = false)
	private TipZnamenitosti tipZnamenitosti;

	public Znamenitost(float longitude, float latitude, String adresa, String naziv, String opis,
			TipZnamenitosti tipZnamenitosti) {
		super(longitude, latitude, adresa, naziv, opis);
		this.tipZnamenitosti = tipZnamenitosti;
	}
	
	
	
}
