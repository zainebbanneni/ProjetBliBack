package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, String>{
	
	Collaborateur findByCUID(String CUID);

}
