package com.example.crud.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.example.crud.entities.ESIMB;
import com.example.crud.entities.Fonction;
import com.example.crud.repository.Acte_traitementRepository;
import com.example.crud.repository.ESIMBRepository;
import com.example.crud.repository.FonctionRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ESIMBController {
	@Autowired
	ESIMBRepository ESIMBRepo;
	@Autowired
	Acte_traitementRepository actetraitementRepository;
	@Autowired 
	FonctionRepository fonctionRepository;
	
	
	@PostMapping("/add")
	public String create(@RequestBody Fonction fonction, @RequestParam String idacte, @RequestParam String codeIMB, @RequestParam String date_verification ) {
		fonctionRepository.save(new Fonction(fonction.getId_fonction(), fonction.getDescription()) );
		ESIMB esimb= new ESIMB(idacte, codeIMB, date_verification);
		ESIMBRepo.save(esimb);
		return ("ok");
	}

	@GetMapping("/tickets")
	public List<ESIMB> getAll(){
		return ESIMBRepo.findAll();
	}


	@GetMapping("/tickets/{id_acte}")
	public ResponseEntity<ESIMB> getESIMBByIdActe(@PathVariable("idacte") String idacte) {
		Optional<ESIMB> esimbData = ESIMBRepo.findByIdacte(idacte);

		if (esimbData.isPresent()) {
			return new ResponseEntity<>(esimbData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@PutMapping("/tickets/{idacte}")
	public ResponseEntity<ESIMB> update (@PathVariable String idacte, @RequestBody ESIMB esimb) {
		Optional<ESIMB> esimbData = ESIMBRepo.findByCodeIMB(idacte);

		if (esimbData.isPresent()) {
			ESIMB _esimb = esimbData.get();
			_esimb.setCodeIMB(esimb.getCodeIMB());
			_esimb.setIdacte(esimb.getIdacte());
			_esimb.setDate_verification(esimb.getDate_verification());
			return new ResponseEntity<>(ESIMBRepo.save(_esimb), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/*@PostMapping("/add")
    public ResponseEntity<ESIMB >add(@RequestBody ESIMB esimb) {
    
    	esimbService.add(esimb);
        ResponseEntity<ESIMB> Esimb= new ResponseEntity<ESIMB>(esimb,HttpStatus.OK);
        return Esimb;
    }
	@GetMapping("/all")
    public ResponseEntity<List<ESIMB>> getAll () {
        List<ESIMB> tickets = esimbService.findAll();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/find/{id_acte}")
    public ResponseEntity<ESIMB> getByIdActe (@PathVariable("Id_acte") String Id_acte) {
    	ESIMB Esimb = esimbService.findById_Acte(Id_acte);
        return new ResponseEntity<>(Esimb, HttpStatus.OK);
    }
    
    @GetMapping("/find/{code_IMB}")
    public ResponseEntity<ESIMB> getByCodeIMB (@PathVariable("code") String code_IMB) {
    	ESIMB Esimb = esimbService.findByCode_IMB(code_IMB);
        return new ResponseEntity<>(Esimb, HttpStatus.OK);
    }*/
	
	


}
