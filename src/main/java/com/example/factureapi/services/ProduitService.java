package com.example.factureapi.services;

import com.example.factureapi.models.Produit;
import com.example.factureapi.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

  @Autowired
  private ProduitRepository produitRepository;

  public List<Produit> getAllProduits() {
    return produitRepository.findAll();
  }

  public Produit getProduitById(Long id) {
    Optional<Produit> produit = produitRepository.findById(id);
    return produit.orElse(null);
  }

  public Produit createProduit(Produit produit) {
    return produitRepository.save(produit);
  }

  public Produit updateProduit(Long id, Produit produitDetails) {
    Optional<Produit> existingProduitOpt = produitRepository.findById(id);

    if (existingProduitOpt.isPresent()) {
      Produit existingProduit = existingProduitOpt.get();
      existingProduit.setNom(produitDetails.getNom());
      existingProduit.setDescription(produitDetails.getDescription());
      existingProduit.setPrixUnitaireHT(produitDetails.getPrixUnitaireHT());
      existingProduit.setTauxTVA(produitDetails.getTauxTVA());
      existingProduit.setDateDebutValidite(produitDetails.getDateDebutValidite());
      existingProduit.setDateFinValidite(produitDetails.getDateFinValidite());

      return produitRepository.save(existingProduit);
    } else {
      return null;
    }
  }

  public boolean deleteProduit(Long id) {
    Optional<Produit> existingProduitOpt = produitRepository.findById(id);

    if (existingProduitOpt.isPresent()) {
      produitRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public Produit getProduitByCodeProduit(String codeProduit) {
    Produit produit = produitRepository.findByCodeProduit(codeProduit);
    return null ;
  }
}
