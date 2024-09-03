package com.example.factureapi.repositories;

import com.example.factureapi.models.Facture;
import com.example.factureapi.models.FactureDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureDetailsRepository extends JpaRepository<FactureDetails, Long> {
  // Recherche des détails d'une facture par la facture
  List<FactureDetails> findByFacture(Facture facture);
}
