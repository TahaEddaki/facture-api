package com.example.factureapi.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Facture {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, nullable = false)
  private String reference;
  private Date dateFacturation;
  private Date dateEcheance;

  @ManyToOne
  @JoinColumn(name = "client_id", nullable = false)
  private Client client;

  private Double totalHT;
  private Double totalTVA;
  private Double totalTTC;
  private String conditionsReglement;

  @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
  private List<FactureDetails> factureDetails;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Date getDateFacturation() {
    return dateFacturation;
  }

  public void setDateFacturation(Date dateFacturation) {
    this.dateFacturation = dateFacturation;
  }

  public Date getDateEcheance() {
    return dateEcheance;
  }

  public void setDateEcheance(Date dateEcheance) {
    this.dateEcheance = dateEcheance;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public Double getTotalHT() {
    return totalHT;
  }

  public void setTotalHT(Double totalHT) {
    this.totalHT = totalHT;
  }

  public Double getTotalTVA() {
    return totalTVA;
  }

  public void setTotalTVA(Double totalTVA) {
    this.totalTVA = totalTVA;
  }

  public Double getTotalTTC() {
    return totalTTC;
  }

  public void setTotalTTC(Double totalTTC) {
    this.totalTTC = totalTTC;
  }

  public String getConditionsReglement() {
    return conditionsReglement;
  }

  public void setConditionsReglement(String conditionsReglement) {
    this.conditionsReglement = conditionsReglement;
  }

  public List<FactureDetails> getFactureDetails() {
    return factureDetails;
  }

  public void setFactureDetails(List<FactureDetails> factureDetails) {
    this.factureDetails = factureDetails;
  }
}
