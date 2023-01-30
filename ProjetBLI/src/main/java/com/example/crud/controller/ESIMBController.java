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
import com.example.crud.repository.Acte_traitementRepository;
import com.example.crud.repository.ESIMBRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ESIMBController {
	@Autowired
	ESIMBRepository ESIMBRepo;
	@Autowired
	Acte_traitementRepository actetraitementRepository;
	
	
	
	@PostMapping("/add")
	public String create(@RequestBody Acte_traitement acte_traitement, @RequestParam String idacte, @RequestParam String codeIMB, @RequestParam String date_verification ) {
		try{
			actetraitementRepository.save(new Acte_traitement (acte_traitement.getIdactetrait(),
				acte_traitement.getRef_tacheBPU(),
				acte_traitement.getType_prestation(),
				acte_traitement.getType_element(),
				acte_traitement.getQuantite(),
				acte_traitement.getDate_reception(),
				acte_traitement.getDate_livraison(),
				acte_traitement.getDate_validation(),
				acte_traitement.getAffectation(),
				acte_traitement.getDuree(),
				acte_traitement.getCommentaire(),
				acte_traitement.getMotif(),
				acte_traitement.getStatut_facturation(),
				acte_traitement.getDate_reprise(),
				acte_traitement.getReprise_facturable()));
		ESIMB esimb= new ESIMB(idacte, codeIMB, date_verification);
		//ESIMB esimb= new ESIMB("jghg", "jjh", "jhj");


		ESIMBRepo.save(esimb);
		
		return ("ok");
		}
		catch(Exception e ) {
			return "ko";
		}
	}
	
	@GetMapping("/tickets")
	public List<ESIMB> getAll(){
		return ESIMBRepo.findAll();
	}
	
	@GetMapping("/tickets/actes")
	public List<Acte_traitement> getAllActes(){
		return actetraitementRepository.findAll();
	}
	
	@GetMapping("/tickets/actes/{id_acte}")
	public ResponseEntity<Acte_traitement> getESIMBByIdActes(@PathVariable("id_acte") String idactetrait) {
		Optional<Acte_traitement> esimbData = actetraitementRepository.findByidactetrait(idactetrait);

		if (esimbData.isPresent()) {
			return new ResponseEntity<>(esimbData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/tickets/idacte/{id_acte}")
	public ResponseEntity<ESIMB> getESIMBByIdActe(@PathVariable("idacte") String idacte) {
		Optional<ESIMB> esimbData = ESIMBRepo.findByIdacte(idacte);

		if (esimbData.isPresent()) {
			return new ResponseEntity<>(esimbData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/tickets/codeIMB/{codeIMB}")
	public ArrayList<ESIMB> getESIMBByCodeIMB(@PathVariable("codeIMB") String codeIMB) {
		ESIMB es = new ESIMB("123", "12", "hh");
		ESIMB es1 = new ESIMB("123", "12", "hhh");
		ArrayList<ESIMB> a= new ArrayList<ESIMB>();
		a.add(es);
		a.add(es1);
		return a;
		/*Optional<ESIMB> esimbData = ESIMBRepo.findByCodeIMB(codeIMB);

		if (esimbData.isPresent()) {
			
			return new ResponseEntity<>(esimbData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}*/
	}
	
	@GetMapping("/tickets/Esimb")
	public ResponseEntity<List<ESIMB>> getesimbbycodeIMB(@RequestParam String codeIMB) {
		try {
			List<ESIMB> esimbs = new ArrayList<ESIMB>();
			if (codeIMB == null)
		    ESIMBRepo.findAll().forEach(esimbs::add);
			else
			ESIMBRepo.findBycodeIMBContaining(codeIMB).forEach(esimbs::add);
			if (esimbs.isEmpty()) {
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(esimbs, HttpStatus.OK);
			} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 }
	
	

	@PutMapping("/tickets")
	public ResponseEntity<ESIMB> update (@RequestBody Acte_traitement acte_traitement, @RequestParam String idacte, @RequestParam String date_verification ) {
		System.out.println("Hi!!");
		Optional<ESIMB> esimbData = ESIMBRepo.findByIdacte(idacte);
		System.out.println(esimbData.toString());
		Optional<Acte_traitement> actetrait = actetraitementRepository.findByidactetrait(acte_traitement.getIdactetrait());
		System.out.println(actetrait.toString());
		//System.out.println("idacte"+ idacte);
		//System.out.println("idactetrait"+ acte_traitement.getIdactetrait());


		if (actetrait.isPresent()) {
			Acte_traitement _actetrait = actetrait.get();
			_actetrait.setType_prestation(acte_traitement.getType_prestation());
			_actetrait.setType_element(acte_traitement.getType_element());
			_actetrait.setQuantite(acte_traitement.getQuantite());
			_actetrait.setDate_reception(acte_traitement.getDate_reception());
			_actetrait.setDate_livraison(acte_traitement.getDate_livraison());
			_actetrait.setDate_validation(acte_traitement.getDate_validation());
			_actetrait.setAffectation(acte_traitement.getAffectation());
			_actetrait.setDuree(acte_traitement.getDuree());
			_actetrait.setCommentaire(acte_traitement.getCommentaire());
			_actetrait.setMotif(acte_traitement.getMotif());
			_actetrait.setStatut_facturation(acte_traitement.getStatut_facturation());
			_actetrait.setDate_reprise(acte_traitement.getDate_reprise());
			_actetrait.setReprise_facturable(acte_traitement.getReprise_facturable());
			//System.out.println("dhgdd!!");
			
		}
	
		

		if (esimbData.isPresent()) {
			ESIMB _esimb = esimbData.get();
			_esimb.setDate_verification(date_verification);
			return new ResponseEntity<>(ESIMBRepo.save(_esimb), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
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
	
	



