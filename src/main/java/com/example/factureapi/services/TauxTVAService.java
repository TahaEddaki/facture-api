package com.example.factureapi.services;

import com.example.factureapi.models.TauxTVA;
import com.example.factureapi.repositories.TauxTVARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TauxTVAService {

  @Autowired
  private TauxTVARepository tauxTVARepository;

  public List<TauxTVA> getAllTauxTVA() {
    return tauxTVARepository.findAll();
  }

  public TauxTVA getTauxTVAById(Long id) {
    Optional<TauxTVA> tauxTVA = tauxTVARepository.findById(id);
    return tauxTVA.orElse(null);
  }

  public TauxTVA createTauxTVA(TauxTVA tauxTVA) {
    return tauxTVARepository.save(tauxTVA);
  }

  public TauxTVA updateTauxTVA(Long id, TauxTVA tauxTVADetails) {
    Optional<TauxTVA> existingTauxTVAOpt = tauxTVARepository.findById(id);

    if (existingTauxTVAOpt.isPresent()) {
      TauxTVA existingTauxTVA = existingTauxTVAOpt.get();
      existingTauxTVA.setTaux(tauxTVADetails.getTaux());
      existingTauxTVA.setDateDebutValidite(tauxTVADetails.getDateDebutValidite());
      existingTauxTVA.setDateFinValidite(tauxTVADetails.getDateFinValidite());

      return tauxTVARepository.save(existingTauxTVA);
    } else {
      return null;
    }
  }

  public boolean deleteTauxTVA(Long id) {
    Optional<TauxTVA> existingTauxTVAOpt = tauxTVARepository.findById(id);

    if (existingTauxTVAOpt.isPresent()) {
      tauxTVARepository.deleteById(id);
      return true;
    } else {
      return false;
    }
  }

  public List<TauxTVA> getTauxTVAActifs(Date currentDate) {
    return tauxTVARepository.findByDateDebutValiditeBeforeAndDateFinValiditeAfter(currentDate, currentDate);
  }
}
