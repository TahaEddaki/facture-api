package com.example.factureapi.controllers;

import com.example.factureapi.models.Client;
import com.example.factureapi.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

  @Autowired
  private ClientService clientService;

  @GetMapping
  public List<Client> getAllClients() {
    return clientService.getAllClients();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClientById(@PathVariable Long id) {
    Client client = clientService.getClientById(id);
    if (client != null) {
      return ResponseEntity.ok(client);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public Client createClient(@RequestBody Client client) {
    return clientService.createClient(client);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
    Client updatedClient = clientService.updateClient(id, clientDetails);
    if (updatedClient != null) {
      return ResponseEntity.ok(updatedClient);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    boolean isDeleted = clientService.deleteClient(id);
    if (isDeleted) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/code/{codeClient}")
  public ResponseEntity<Client> getClientByCodeClient(@PathVariable String codeClient) {
    Client client = clientService.getClientByCodeClient(codeClient);
    if (client != null) {
      return ResponseEntity.ok(client);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
