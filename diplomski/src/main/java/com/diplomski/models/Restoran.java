package com.diplomski.models;

import com.diplomski.enums.TipRestorana;
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
public class Restoran extends Destinacija{

	
	@Enumerated(EnumType.STRING)
	@Column(name= "tip_restorana", nullable = false)
	private TipRestorana tipRestorana;

	public Restoran(float longitude, float latitude, String adresa, String naziv, String opis,
			   TipRestorana tipRestorana) {
		super(longitude, latitude, adresa, naziv, opis);
		this.tipRestorana = tipRestorana;
	}
	
	
}
