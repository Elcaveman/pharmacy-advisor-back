package com.example.pharmacieapi.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PharmacieDeGarde {

	@EmbeddedId
	private PharmacieDeGardeRelation PharmacieDeGardeRelation = new PharmacieDeGardeRelation();
	private Date dateFin;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pharmaciePK",nullable = false, insertable = false, updatable = false)
	@MapsId("pharmaciePK")
	private Pharmacie pharmacie;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gardePK", nullable = false, insertable = false, updatable = false)
	@MapsId("gardePK")
	private Garde garde;


	public PharmacieDeGardeRelation getPharmacieDeGardePK() {
		return PharmacieDeGardeRelation;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Pharmacie getPharmacie() {
		return pharmacie;
	}

	public void setPharmacie(Pharmacie pharmacie) {
		this.pharmacie = pharmacie;
	}

	public Garde getGarde() {
		return garde;
	}

	public PharmacieDeGarde() {
		super();
	}

}
