package com.example.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.ESIMB;

@Repository
public interface ESIMBRepository extends JpaRepository<ESIMB, String> {
	Optional<ESIMB> findByCodeIMB(String codeIMB);
	Optional<ESIMB> findByIdacte(String idacte);
	
	List<ESIMB> findBycodeIMBContaining(String codeIMB);





}
