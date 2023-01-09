package com.example.pharmacieapi.dto;

import com.example.pharmacieapi.entity.Pharmacie;
import com.example.pharmacieapi.entity.Zone;
import com.example.pharmacieapi.repositories.ZoneRepository;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@Builder
public class PharmacieDto {
    private int id;
    private String nom;
    private String adresse;
    private String telephone;
    private Double lat;
    private Double log;
    private int etat;
    private int zone_id;

    public Pharmacie dtoToEntity(Zone zone) {
        return Pharmacie.builder()
                .id(id)
                .nom(nom)
                .adresse(adresse)
                .telephone(telephone)
                .lat(lat)
                .log(log)
                .etat(etat)
                .zone(zone)
                .build();
    }
}
