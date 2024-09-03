package com.example.factureapi.services;

import com.example.factureapi.models.Facture;
import com.example.factureapi.models.Client;
import com.example.factureapi.repositories.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

  @Autowired
  private FactureRepository factureRepository;

  public List<Facture> getAllFactures() {
    return factureRepository.findAll();
  }

  public Facture getFactureById(Long id) {
    Optional<Facture> facture = factureRepository.findById(id);
    return facture.orElse(null);
  }

  public Facture createFacture(Facture facture) {
    return factureRepository.save(facture);
  }

  public Facture updateFacture(Long id, Facture factureDetails) {
    Optional<Facture> existingFactureOpt = factureRepository.findById(id);

    if (existingFactureOpt.isPresent()) {
      Facture existingFacture = existingFactureOpt.get();
      existingFacture.setDateFacturation(factureDetails.getDateFacturation());
      existingFacture.setDateEcheance(factureDetails.getDateEcheance());
      existingFacture.setClient(factureDetails.getClient());
      existingFacture.setTotalHT(factureDetails.getTotalHT());
      existingFacture.setTotalTVA(factureDetails.getTotalTVA());
      existingFacture.setTotalTTC(factureDetails.getTotalTTC());
      existingFacture.setConditionsReglement(factureDetails.getConditionsReglement());

      return factureRepository.save(existingFacture);
    } else {
      return null;
    }
  }

  public boolean deleteFacture(Long id) {
    Optional<Facture> existingFactureOpt = factureRepository.findById(id);

    if (existingFactureOpt.isPresent()) {
      factureRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public List<Facture> getFacturesByClient(Client client) {
    return factureRepository.findByClient(client);
  }

  public List<Facture> getFacturesByDateRange(Date startDate, Date endDate) {
    return factureRepository.findByDateFacturationBetween(startDate, endDate);
  }

  public Long countFacturesByClient(Client client) {
    return factureRepository.countByClient(client);
  }
}
