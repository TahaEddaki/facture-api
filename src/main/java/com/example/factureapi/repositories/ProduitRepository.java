package com.example.factureapi.repositories;

import com.example.factureapi.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProduitRepository extends JpaRepository<Produit, Long> {
  // Recherche d'un produit par son code produit
  Produit findByCodeProduit(String codeProduit);
}
