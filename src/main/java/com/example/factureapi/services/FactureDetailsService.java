package com.example.factureapi.services;

import com.example.factureapi.models.Facture;
import com.example.factureapi.models.FactureDetails;
import com.example.factureapi.repositories.FactureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureDetailsService {

  @Autowired
  private FactureDetailsRepository factureDetailsRepository;

  public List<FactureDetails> getAllFactureDetails() {
    return factureDetailsRepository.findAll();
  }

  public FactureDetails getFactureDetailsById(Long id) {
    Optional<FactureDetails> factureDetails = factureDetailsRepository.findById(id);
    return factureDetails.orElse(null);
  }

  public FactureDetails createFactureDetails(FactureDetails factureDetails) {
    return factureDetailsRepository.save(factureDetails);
  }

  public FactureDetails updateFactureDetails(Long id, FactureDetails factureDetailsDetails) {
    Optional<FactureDetails> existingFactureDetailsOpt = factureDetailsRepository.findById(id);

    if (existingFactureDetailsOpt.isPresent()) {
      FactureDetails existingFactureDetails = existingFactureDetailsOpt.get();
      existingFactureDetails.setQuantite(factureDetailsDetails.getQuantite());
      existingFactureDetails.setPrixUnitaireHT(factureDetailsDetails.getPrixUnitaireHT());
      existingFactureDetails.setTauxTVA(factureDetailsDetails.getTauxTVA());
      existingFactureDetails.setTotalHT(factureDetailsDetails.getTotalHT());
      existingFactureDetails.setTotalTTC(factureDetailsDetails.getTotalTTC());
      existingFactureDetails.setFacture(factureDetailsDetails.getFacture());
      existingFactureDetails.setProduit(factureDetailsDetails.getProduit());

      return factureDetailsRepository.save(existingFactureDetails);
    } else {
      return null;
    }
  }

  public boolean deleteFactureDetails(Long id) {
    Optional<FactureDetails> existingFactureDetailsOpt = factureDetailsRepository.findById(id);

    if (existingFactureDetailsOpt.isPresent()) {
      factureDetailsRepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public List<FactureDetails> getFactureDetailsByFacture(Facture facture) {
    return factureDetailsRepository.findByFacture(facture);
  }
}
