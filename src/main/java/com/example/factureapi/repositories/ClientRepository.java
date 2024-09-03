package com.example.factureapi.repositories;

import com.example.factureapi.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, Long> {
  Client findByCodeClient(String codeClient);
}