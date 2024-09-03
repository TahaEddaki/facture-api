package com.example.factureapi.services;

import com.example.factureapi.models.Client;
import com.example.factureapi.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  /**
   * Récupère tous les clients.
   * @return une liste de tous les clients
   */
  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  /**
   * Récupère un client par son ID.
   * @param id l'ID du client
   * @return le client correspondant à l'ID ou null si non trouvé
   */
  public Client getClientById(Long id) {
    Optional<Client> client = clientRepository.findById(id);
    return client.orElse(null);  // Retourne null si le client n'est pas trouvé
  }

  /**
   * Crée un nouveau client.
   * @param client le client à créer
   * @return le client créé
   */
  public Client createClient(Client client) {
    return clientRepository.save(client);
  }

  /**
   * Met à jour un client existant.
   * @param id l'ID du client à mettre à jour
   * @param clientDetails les nouvelles informations du client
   * @return le client mis à jour ou null si non trouvé
   */
  public Client updateClient(Long id, Client clientDetails) {
    Optional<Client> existingClientOpt = clientRepository.findById(id);

    if (existingClientOpt.isPresent()) {
      Client existingClient = existingClientOpt.get();
      existingClient.setNom(clientDetails.getNom());
      existingClient.setAdresse(clientDetails.getAdresse());
      existingClient.setCodePostal(clientDetails.getCodePostal());
      existingClient.setVille(clientDetails.getVille());
      existingClient.setPays(clientDetails.getPays());
      existingClient.setTelephone(clientDetails.getTelephone());
      existingClient.setEmail(clientDetails.getEmail());

      return clientRepository.save(existingClient);
    } else {
      return null;  // Retourne null si le client n'est pas trouvé
    }
  }

  /**
   * Supprime un client par son ID.
   * @param id l'ID du client à supprimer
   * @return true si le client a été supprimé, false si non trouvé
   */
  public boolean deleteClient(Long id) {
    Optional<Client> existingClientOpt = clientRepository.findById(id);

    if (existingClientOpt.isPresent()) {
      clientRepository.deleteById(id);
      return true;  // Retourne true si la suppression a réussi
    } else {
      return false;  // Retourne false si le client n'est pas trouvé
    }
  }

  /**
   * Recherche un client par son code client.
   * @param codeClient le code client
   * @return le client correspondant au code client ou null si non trouvé
   */
  public Client getClientByCodeClient(String codeClient) {
    Client client = clientRepository.findByCodeClient(codeClient);
    return null;  // Retourne null si le client n'est pas trouvé
  }
}
