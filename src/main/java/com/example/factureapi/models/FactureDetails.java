package com.example.factureapi.models;

import jakarta.persistence.*;

@Entity
public class FactureDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "facture_id", nullable = false)
  private Facture facture;

  @ManyToOne
  @JoinColumn(name = "produit_id", nullable = false)
  private Produit produit;

  private Integer quantite;
  private Double prixUnitaireHT;
  private Double tauxTVA;
  private Double totalHT;
  private Double totalTTC;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Facture getFacture() {
    return facture;
  }

  public void setFacture(Facture facture) {
    this.facture = facture;
  }

  public Produit getProduit() {
    return produit;
  }

  public void setProduit(Produit produit) {
    this.produit = produit;
  }

  public Integer getQuantite() {
    return quantite;
  }

  public void setQuantite(Integer quantite) {
    this.quantite = quantite;
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

  public Double getTotalHT() {
    return totalHT;
  }

  public void setTotalHT(Double totalHT) {
    this.totalHT = totalHT;
  }

  public Double getTotalTTC() {
    return totalTTC;
  }

  public void setTotalTTC(Double totalTTC) {
    this.totalTTC = totalTTC;
  }
}