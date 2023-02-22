package com.example.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.ESIMB;
import com.example.crud.entities.Graphic;

@Repository
public interface ESIMBRepository extends JpaRepository<ESIMB, String> {
	//Optional<ESIMB> findByCodeIMB(String codeIMB);
	List<ESIMB> findByCodeIMB(String codeIMB);
	//Optional<ESIMB> findByIdacte(String idacte);
	
	//Optional<ESIMB> findByidacte(String idacte);
	Optional<ESIMB> findByidacte(String idacte);
	

	List<ESIMB> findByaffectationContaining(String affectation);
	 List<ESIMB> findBydateLivraison(String dateLivraison);
		List<ESIMB> findBycodeIMBContaining(String codeIMB);
		List<ESIMB>findBycodeBanbouContaining(String codeBanbou);
		 List<ESIMB> findByAffectation(String affectation);  









}
