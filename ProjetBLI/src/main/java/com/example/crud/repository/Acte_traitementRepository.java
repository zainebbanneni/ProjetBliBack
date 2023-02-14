package com.example.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.Acte_traitement;

@Repository
public interface Acte_traitementRepository extends JpaRepository<Acte_traitement, String> {
	Optional<Acte_traitement> findByidactetrait(String idactetrait);
	



}
