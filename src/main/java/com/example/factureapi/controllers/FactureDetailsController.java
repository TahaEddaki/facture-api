package com.example.factureapi.controllers;

import com.example.factureapi.models.Facture;
import com.example.factureapi.models.FactureDetails;
import com.example.factureapi.services.FactureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facture-details")
public class FactureDetailsController {

  @Autowired
  private FactureDetailsService factureDetailsService;

  @GetMapping
  public List<FactureDetails> getAllFactureDetails() {
    return factureDetailsService.getAllFactureDetails();
  }

  @GetMapping("/{id}")
  public ResponseEntity<FactureDetails> getFactureDetailsById(@PathVariable Long id) {
    FactureDetails factureDetails = factureDetailsService.getFactureDetailsById(id);
    if (factureDetails != null) {
      return ResponseEntity.ok(factureDetails);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public FactureDetails createFactureDetails(@RequestBody FactureDetails factureDetails) {
    return factureDetailsService.createFactureDetails(factureDetails);
  }

  @PutMapping("/{id}")
  public ResponseEntity<FactureDetails> updateFactureDetails(@PathVariable Long id, @RequestBody FactureDetails factureDetailsDetails) {
    FactureDetails updatedFactureDetails = factureDetailsService.updateFactureDetails(id, factureDetailsDetails);
    if (updatedFactureDetails != null) {
      return ResponseEntity.ok(updatedFactureDetails);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFactureDetails(@PathVariable Long id) {
    boolean isDeleted = factureDetailsService.deleteFactureDetails(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/facture/{factureId}")
  public List<FactureDetails> getFactureDetailsByFacture(@PathVariable Long factureId) {
    Facture facture = new Facture();
    facture.setId(factureId);
    return factureDetailsService.getFactureDetailsByFacture(facture);
  }
}