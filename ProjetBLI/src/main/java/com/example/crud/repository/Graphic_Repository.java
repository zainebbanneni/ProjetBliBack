package com.example.crud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Graphic;

public interface Graphic_Repository extends JpaRepository<Graphic, String> {
	//Graphic findByid_Grafic(String id_Grafic);
	 //ist<Graphic> findByidContaining(String id_Grafic);
	 //Graphic  findBycode_imb(String id_Grafic); 
	 Optional<Graphic>  findByidGrafic(String id_Grafic);
	 List<Graphic> findByidGraficContaining(String id_Grafic);
	 List<Graphic> findBydateTraitement(String dateTraitement);
	 List<Graphic> findBydateTraitementContaining(String dateTraitement);

}
