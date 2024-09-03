package com.example.factureapi.controllers;

import com.example.factureapi.models.Facture;
import com.example.factureapi.models.Client;
import com.example.factureapi.services.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

  @Autowired
  private FactureService factureService;

  @GetMapping
  public List<Facture> getAllFactures() {
    return factureService.getAllFactures();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Facture> getFactureById(@PathVariable Long id) {
    Facture facture = factureService.getFactureById(id);
    if (facture != null) {
      return ResponseEntity.ok(facture);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Facture createFacture(@RequestBody Facture facture) {
    return factureService.createFacture(facture);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Facture> updateFacture(@PathVariable Long id, @RequestBody Facture factureDetails) {
    Facture updatedFacture = factureService.updateFacture(id, factureDetails);
    if (updatedFacture != null) {
      return ResponseEntity.ok(updatedFacture);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
    boolean isDeleted = factureService.deleteFacture(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/client/{clientId}")
  public List<Facture> getFacturesByClient(@PathVariable Long clientId) {
    Client client = new Client();
    client.setId(clientId);
    return factureService.getFacturesByClient(client);
  }

  @GetMapping("/date-range")
  public List<Facture> getFacturesByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
    return factureService.getFacturesByDateRange(startDate, endDate);
  }
}
