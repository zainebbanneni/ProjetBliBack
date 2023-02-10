package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Collaborateur;
import com.example.crud.repository.CollaborateurRepository;

@RestController
public class CollaborateurController {
	@Autowired
	CollaborateurRepository collaborateurRepository;
	
	
	@GetMapping("/collaborateur/{cuid}")
	public Collaborateur getCollaborateur(@PathVariable String cuid){
		return collaborateurRepository.findByCUID(cuid);
	}
	
	@GetMapping("/collaborateur/getAllCollaborateursbypilote/{cuid}")
	public List<Collaborateur> getAllCollaborateursbypilote(@PathVariable String cuid){
		Collaborateur pilote = collaborateurRepository.findByCUID(cuid);
		return collaborateurRepository.findByidequipe(pilote.getIdequipe());
	}
	

}
