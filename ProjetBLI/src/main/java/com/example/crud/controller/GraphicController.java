package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Acte_traitement;
import com.example.crud.entities.Graphic;
import com.example.crud.repository.Acte_traitementRepository;
import com.example.crud.repository.Graphic_Repository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/graphic")
public class GraphicController {
	@Autowired
    private Graphic_Repository graphic_Repository;
    @Autowired
	Acte_traitementRepository actetraitementRepository;

  //Add new graphic
    @PostMapping("/add")
	public String addGraphic(@RequestBody Acte_traitement acte_traitement, @RequestParam String id_Grafic, @RequestParam String iar, @RequestParam String code_imb, @RequestParam String groupe_operation, @RequestParam String date_traitement, @RequestParam String statut_graphic, @RequestParam String traitement_effectue, @RequestParam String type_traitement){
		
        try {
            actetraitementRepository.save(
                new Acte_traitement (acte_traitement.getIdactetrait(),
				acte_traitement.getRefTacheBPU(),
				acte_traitement.getType_prestation(),
				acte_traitement.getType_element(),
				acte_traitement.getQuantite(),
				acte_traitement.getDateReception(),
				acte_traitement.getDateLivraison(),
				acte_traitement.getDateReception(),
				acte_traitement.getAffectation(),
				acte_traitement.getDuree(),
				acte_traitement.getCommentaire(),
				acte_traitement.getMotif(),
				acte_traitement.getStatutFacturation(),
				acte_traitement.getDateReprise(),
				acte_traitement.getRepriseFacturable()));
                graphic_Repository.save(new Graphic(id_Grafic,iar,code_imb,groupe_operation,date_traitement,statut_graphic,traitement_effectue,type_traitement));
                return "ok";
        } catch (Exception e) {
                return "KO : "+e.getMessage();
        }
        
	}

	//Get All Graphics
	@GetMapping("/getAll")
	public List<Graphic> getAll(){
		return graphic_Repository.findAll();
	}

	//Get Graphic by id Graphic
	@GetMapping("/getGraphicById/{idGraphicString}")
	public List<Graphic> getGraphicByIdGraphic(@PathVariable String idGraphicString){
		return graphic_Repository.findByidGraficContaining(idGraphicString);
	}

	//Get Graphic by Date de traitement
	@GetMapping("/getGraphicByDT/{dateTtraitement}")
	public List<Graphic> getGrphicBydateTraitement(@PathVariable String dateTtraitement){
		return graphic_Repository.findBydateTraitement(dateTtraitement);
	}

	//Update graphic
	@PutMapping("/Update")
	public ResponseEntity<Graphic> update(@RequestBody Acte_traitement acte_traitement, @RequestParam String id_Grafic, @RequestParam String iar, @RequestParam String code_imb, @RequestParam String groupe_operation, @RequestParam String date_traitement, @RequestParam String statut_graphic, @RequestParam String traitement_effectue, @RequestParam String type_traitement){
		
		//get the graphic to update
		Optional<Graphic> graphicData = graphic_Repository.findByidGrafic(id_Grafic);
		//get the graphic to update
		Optional<Acte_traitement> actetrait = actetraitementRepository.findByidactetrait(acte_traitement.getIdactetrait());
        
		//Update Acte Traitment
		if (actetrait.isPresent()) {
			System.out.println("actetrait exists");
			Acte_traitement _actetrait = actetrait.get();
			_actetrait.setType_prestation(acte_traitement.getType_prestation());
			_actetrait.setType_element(acte_traitement.getType_element());
			_actetrait.setQuantite(acte_traitement.getQuantite());
			_actetrait.setDateReception(acte_traitement.getDateReception());
			_actetrait.setDateLivraison(acte_traitement.getDateLivraison());
			_actetrait.setDateReception(acte_traitement.getDateReception());
			_actetrait.setAffectation(acte_traitement.getAffectation());
			_actetrait.setDuree(acte_traitement.getDuree());
			_actetrait.setCommentaire(acte_traitement.getCommentaire());
			_actetrait.setMotif(acte_traitement.getMotif());
			_actetrait.setStatutFacturation(acte_traitement.getStatutFacturation());
			_actetrait.setDateReprise(acte_traitement.getDateReprise());
			_actetrait.setRepriseFacturable(acte_traitement.getRepriseFacturable());
			actetraitementRepository.save(_actetrait);
		}else {
			System.out.println("not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		//Save the updated graphic
		if (graphicData.isPresent()) {
			System.out.println("graphicData exists");
			Graphic _graphic = graphicData.get();
			_graphic.setidGrafic(id_Grafic);
			_graphic.setCode_imb(code_imb);
			_graphic.setIar(iar);
			_graphic.setStatut_graphic(statut_graphic);
			_graphic.setTraitement_effectue(traitement_effectue);
			_graphic.setType_traitement(type_traitement);
			_graphic.setdateTraitement(type_traitement);
			_graphic.setgroupe_operation(groupe_operation);
			return new ResponseEntity<>(graphic_Repository.save(_graphic), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
