package com.example.factureapi.controllers;

import com.example.factureapi.models.TauxTVA;
import com.example.factureapi.services.TauxTVAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/taux-tva")
public class TauxTVAController {

  @Autowired
  private TauxTVAService tauxTVAService;

  @GetMapping
  public List<TauxTVA> getAllTauxTVA() {
    return tauxTVAService.getAllTauxTVA();
  }

  @GetMapping("/{id}")
  public ResponseEntity<TauxTVA> getTauxTVAById(@PathVariable Long id) {
    TauxTVA tauxTVA = tauxTVAService.getTauxTVAById(id);
    if (tauxTVA != null) {
      return ResponseEntity.ok(tauxTVA);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public TauxTVA createTauxTVA(@RequestBody TauxTVA tauxTVA) {
    return tauxTVAService.createTauxTVA(tauxTVA);
  }

  @PutMapping("/{id}")
  public ResponseEntity<TauxTVA> updateTauxTVA(@PathVariable Long id, @RequestBody TauxTVA tauxTVADetails) {
    TauxTVA updatedTauxTVA = tauxTVAService.updateTauxTVA(id, tauxTVADetails);
    if (updatedTauxTVA != null) {
      return ResponseEntity.ok(updatedTauxTVA);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteTauxTVA(@PathVariable Long id) {
    boolean isDeleted = tauxTVAService.deleteTauxTVA(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/actifs")
  public List<TauxTVA> getTauxTVAActifs(@RequestParam Date currentDate) {
    return tauxTVAService.getTauxTVAActifs(currentDate);
  }
}
