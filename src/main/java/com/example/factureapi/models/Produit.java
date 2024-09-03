package com.example.factureapi.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

public class Produit {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String codeProduit;
  private String nom;
  private String description;
  private Double prixUnitaireHT;
  private Double tauxTVA;
  private Date dateDebutValidite;
  private Date dateFinValidite;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCodeProduit() {
    return codeProduit;
  }

  public void setCodeProduit(String codeProduit) {
    this.codeProduit = codeProduit;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrixUnitaireHT() {
    return prixUnitaireHT;
  }

  public void setPrixUnitaireHT(Double prixUnitaireHT) {
    this.prixUnitaireHT = prixUnitaireHT;
  }

  public Double getTauxTVA() {
    return tauxTVA;
  }

  public void setTauxTVA(Double tauxTVA) {
    this.tauxTVA = tauxTVA;
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