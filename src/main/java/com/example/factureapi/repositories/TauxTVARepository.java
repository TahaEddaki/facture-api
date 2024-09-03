package com.example.factureapi.repositories;

import com.example.factureapi.models.TauxTVA;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TauxTVARepository extends JpaRepository<TauxTVA, Long> {
  // Recherche des taux de TVA actifs à une date donnée
  List<TauxTVA> findByDateDebutValiditeBeforeAndDateFinValiditeAfter(Date currentDate1, Date currentDate2);
}
