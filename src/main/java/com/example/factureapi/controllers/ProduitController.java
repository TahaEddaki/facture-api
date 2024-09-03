package com.example.factureapi.controllers;

import com.example.factureapi.models.Produit;
import com.example.factureapi.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

  @Autowired
  private ProduitService produitService;

  @GetMapping
  public List<Produit> getAllProduits() {
    return produitService.getAllProduits();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
    Produit produit = produitService.getProduitById(id);
    if (produit != null) {
      return ResponseEntity.ok(produit);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Produit createProduit(@RequestBody Produit produit) {
    return produitService.createProduit(produit);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produitDetails) {
    Produit updatedProduit = produitService.updateProduit(id, produitDetails);
    if (updatedProduit != null) {
      return ResponseEntity.ok(updatedProduit);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduit(@PathVariable Long id) {
    boolean isDeleted = produitService.deleteProduit(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/code/{codeProduit}")
  public ResponseEntity<Produit> getProduitByCodeProduit(@PathVariable String codeProduit) {
    Produit produit = produitService.getProduitByCodeProduit(codeProduit);
    if (produit != null) {
      return ResponseEntity.ok(produit);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}