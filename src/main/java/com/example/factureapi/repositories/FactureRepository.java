package com.example.factureapi.repositories;

import com.example.factureapi.models.Client;
import com.example.factureapi.models.Facture;
import com.example.factureapi.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FactureRepository extends JpaRepository<Facture, Long> {
  // Recherche des factures par client
  List<Facture> findByClient(Client client);

  // Recherche des factures par plage de dates
  List<Facture> findByDateFacturationBetween(Date startDate, Date endDate);

  // Comptage des factures pour un client spécifique
  Long countByClient(Client client);
}
