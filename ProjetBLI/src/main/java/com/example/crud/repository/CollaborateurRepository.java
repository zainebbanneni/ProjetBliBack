package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Collaborateur;

public interface CollaborateurRepository extends JpaRepository<Collaborateur, String>{
	
	Collaborateur findByCUID(String CUID);
	List<Collaborateur> findByidequipe(String idequipe);


}
