package com.example.factureapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TauxTVA {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Double taux;
  private Date dateDebutValidite;
  private Date dateFinValidite;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getTaux() {
    return taux;
  }

  public void setTaux(Double taux) {
    this.taux = taux;
  }

  public Date getDateDebutValidite() {
    return dateDebutValidite;
  }

  public void setDateDebutValidite(Date dateDebutValidite) {
    this.dateDebutValidite = dateDebutValidite;
  }

  public Date getDateFinValidite() {
    return dateFinValidite;
  }

  public void setDateFinValidite(Date dateFinValidite) {
    this.dateFinValidite = dateFinValidite;
  }
}
