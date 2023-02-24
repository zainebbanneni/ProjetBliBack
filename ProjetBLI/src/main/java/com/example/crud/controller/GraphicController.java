package com.example.crud.controller;

import java.util.List;
import java.util.Objects;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Collaborateur;
import com.example.crud.entities.Graphic;
import com.example.crud.entities.models.Grafic_Resp;
import com.example.crud.repository.Acte_traitementRepository;
import com.example.crud.repository.CollaborateurRepository;
import com.example.crud.repository.Graphic_Repository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/graphic")
public class GraphicController {
	@Autowired
    private Graphic_Repository graphic_Repository;
    @Autowired
	Acte_traitementRepository actetraitementRepository;
	@Autowired
	CollaborateurRepository collaborateurRepository;
 
	
// DONE -------------------------------------------------------------------------------------------------------------------------------------------
	
	//Add new graphic
    @PostMapping("/Add")
	public String addGraphic(@RequestBody Graphic graphic){
		
        try {
                graphic_Repository.save(
                				new Graphic(graphic.getRefTacheBPU(),
                						    graphic.getType_prestation(),
                						    graphic.getType_element(),
                						    graphic.getQuantite(),
                						    graphic.getDateReception(),
                						    graphic.getDateLivraison(),
                						    graphic.getDateValidation(),
                						    graphic.getAffectation(),
                						    graphic.getDuree(),
                						    graphic.getCommentaire(),
                						    graphic.getMotif(),
                						    graphic.getStatutFacturation(),
                						    graphic.getDateReprise(),
                						    graphic.getRepriseFacturable(),
                							graphic.getidGrafic(),
	                						graphic.getIar(),
	                						graphic.getCode_imb(),
	                						graphic.getgroupe_operation(),
	                						graphic.getdateTraitement(),
	                						graphic.getStatut_graphic(),
	                						graphic.getTraitement_effectue(),
	                						graphic.getType_traitement(),
	                						true));
                return "ok";
        } catch (Exception e) {
                return "KO : "+e.getMessage();
        }
        
	}
    
  //----------------------------------------------------------------
  	//Get Active Grafics
  	@GetMapping("/getActiveGraphics")
  	public ResponseEntity<List<Grafic_Resp>> getGraphics(@RequestParam String cuid){
  		try {
  		boolean isPilote = false;
  		
  		//response global 
  		List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
  		Grafic_Resp _graphic = new Grafic_Resp();
  		
  		//get All grafics
  		List<Graphic> _allgraphics = graphic_Repository.findAll();
  		_graphic = new Grafic_Resp();
  		
  		//get Collab infos
  		Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
  		//check if PILOTE
  		if(_colab_req.getFonction().equals("3")) {
  			isPilote = true;
  		}
  		
  		if(isPilote){
  			for(int i = 0; i < _allgraphics.size(); i++){
  				if(_allgraphics.get(i).isActive()) {
  				Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
  				if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
  					if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
  						_graphic = new Grafic_Resp(
  						_allgraphics.get(i).getidGrafic(),
  						_allgraphics.get(i).getIar(),
  						_allgraphics.get(i).getCode_imb(),
  						_allgraphics.get(i).getgroupe_operation(),
  						_allgraphics.get(i).getdateTraitement(),
  						_allgraphics.get(i).getStatut_graphic(),
  						_allgraphics.get(i).getTraitement_effectue(),
  						_allgraphics.get(i).getType_traitement(),
  						_allgraphics.get(i).getIdacte(),
  						_colab.getNom() + " "+_colab.getPrenom(),
  						_allgraphics.get(i).getDuree(),
  						_allgraphics.get(i).getCommentaire()
  					);
  		
  					response.add(_graphic);
  					}
  				}	
  			}
  			}
  		}else{
              for(int i = 0; i < _allgraphics.size(); i++){
              	if(_allgraphics.get(i).isActive()) {
  				Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
  				if(_colab.getCUID().equals(cuid)){
  					//System.out.println("OK");
  					_graphic = new Grafic_Resp(
  					_allgraphics.get(i).getidGrafic(),
  					_allgraphics.get(i).getIar(),
  					_allgraphics.get(i).getCode_imb(),
  					_allgraphics.get(i).getgroupe_operation(),
  					_allgraphics.get(i).getdateTraitement(),
  					_allgraphics.get(i).getStatut_graphic(),
  					_allgraphics.get(i).getTraitement_effectue(),
  					_allgraphics.get(i).getType_traitement(),
  					_allgraphics.get(i).getIdacte(),
  					_colab.getNom() + " "+_colab.getPrenom(),
  					_allgraphics.get(i).getDuree(),
  					_allgraphics.get(i).getCommentaire()
  				);
  				response.add(_graphic);
  				}
  				
  			}
              }
  		}
          return new ResponseEntity<>(response, HttpStatus.OK);
  		
  		} catch (Exception e) {
  		    System.out.println("erreur "+e);
  			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
  		}	
  	}
  	
//----------------------------------------------------------------
  //Get Non Active Grafics
  @GetMapping("/getNonActiveGraphics")
  public ResponseEntity<List<Grafic_Resp>> getGraphicsNonActive(@RequestParam String cuid){
  	try {
  		boolean isPilote = false;
  			
  		//response global 
  		List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
  		Grafic_Resp _graphic = new Grafic_Resp();
  			
  		//get All grafics
  		List<Graphic> _allgraphics = graphic_Repository.findAll();
  		_graphic = new Grafic_Resp();
  			
  		//get Collab infos
  		Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
  		//check if PILOTE
  		if(_colab_req.getFonction().equals("3")) {
  			isPilote = true;}
  		if(isPilote){
  			for(int i = 0; i < _allgraphics.size(); i++){
  				if(!(_allgraphics.get(i).isActive())) {
  					Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
  					if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
  						if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
  							_graphic = new Grafic_Resp(
  							_allgraphics.get(i).getidGrafic(),
  							_allgraphics.get(i).getIar(),
  							_allgraphics.get(i).getCode_imb(),
  							_allgraphics.get(i).getgroupe_operation(),
  							_allgraphics.get(i).getdateTraitement(),
  							_allgraphics.get(i).getStatut_graphic(),
  							_allgraphics.get(i).getTraitement_effectue(),
  							_allgraphics.get(i).getType_traitement(),
  							_allgraphics.get(i).getIdacte(),
  							_colab.getNom() + " "+_colab.getPrenom(),
  							_allgraphics.get(i).getDuree(),
  							_allgraphics.get(i).getCommentaire()
  						);
  			
  						response.add(_graphic);
  						}
  					}	
  				}
  				}
  			}else{
  	            for(int i = 0; i < _allgraphics.size(); i++){
  	            	if(!(_allgraphics.get(i).isActive())) {
  					Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
  					if(_colab.getCUID().equals(cuid)){
  						//System.out.println("OK");
  						_graphic = new Grafic_Resp(
  						_allgraphics.get(i).getidGrafic(),
  						_allgraphics.get(i).getIar(),
  						_allgraphics.get(i).getCode_imb(),
  						_allgraphics.get(i).getgroupe_operation(),
  						_allgraphics.get(i).getdateTraitement(),
  						_allgraphics.get(i).getStatut_graphic(),
  						_allgraphics.get(i).getTraitement_effectue(),
  						_allgraphics.get(i).getType_traitement(),
  						_allgraphics.get(i).getIdacte(),
  						_colab.getNom() + " "+_colab.getPrenom(),
  						_allgraphics.get(i).getDuree(),
  						_allgraphics.get(i).getCommentaire()
  					);
  					response.add(_graphic);
  					}
  					
  				}
  	            }
  			}
  	        return new ResponseEntity<>(response, HttpStatus.OK);
  			
  			} catch (Exception e) {
  			    System.out.println("erreur "+e);
  				return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
  			}
  			
  			
  		}

  

//------------------------ Get Non Active Grafics by id grafic ----------------------------------------
   @GetMapping("/getActiveByIdGrafic")
		public ResponseEntity<List<Grafic_Resp>> getGraphicsActivebyIdGrafic(@RequestParam String cuid,@RequestParam String idGraphic){
			try {
					boolean isPilote = false;
					
					//response global 
					List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
					Grafic_Resp _graphic = new Grafic_Resp();
					
					//get All grafics containing id grafic
					List<Graphic> _allgraphics = graphic_Repository.findByidGraficContaining(idGraphic);
					_graphic = new Grafic_Resp();
					
					//get Collab infos
					Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
					//check if PILOTE
					if(_colab_req.getFonction().equals("3")) {
						isPilote = true;
					}
					
					if(isPilote){
						for(int i = 0; i < _allgraphics.size(); i++){
							if(_allgraphics.get(i).isActive()) {
							Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
							if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
								if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
									_graphic = new Grafic_Resp(
									_allgraphics.get(i).getidGrafic(),
									_allgraphics.get(i).getIar(),
									_allgraphics.get(i).getCode_imb(),
									_allgraphics.get(i).getgroupe_operation(),
									_allgraphics.get(i).getdateTraitement(),
									_allgraphics.get(i).getStatut_graphic(),
									_allgraphics.get(i).getTraitement_effectue(),
									_allgraphics.get(i).getType_traitement(),
									_allgraphics.get(i).getIdacte(),
									_colab.getNom() + " "+_colab.getPrenom(),
									_allgraphics.get(i).getDuree(),
									_allgraphics.get(i).getCommentaire()
								);
					
								response.add(_graphic);
								}
							}	
						}
						}
					}else{
			            for(int i = 0; i < _allgraphics.size(); i++){
			            	if(_allgraphics.get(i).isActive()) {
							Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
							if(_colab.getCUID().equals(cuid)){
								//System.out.println("OK");
								_graphic = new Grafic_Resp(
								_allgraphics.get(i).getidGrafic(),
								_allgraphics.get(i).getIar(),
								_allgraphics.get(i).getCode_imb(),
								_allgraphics.get(i).getgroupe_operation(),
								_allgraphics.get(i).getdateTraitement(),
								_allgraphics.get(i).getStatut_graphic(),
								_allgraphics.get(i).getTraitement_effectue(),
								_allgraphics.get(i).getType_traitement(),
								_allgraphics.get(i).getIdacte(),
								_colab.getNom() + " "+_colab.getPrenom(),
								_allgraphics.get(i).getDuree(),
								_allgraphics.get(i).getCommentaire()
							);
							response.add(_graphic);
							}
							
						}
			            }
					}
			        return new ResponseEntity<>(response, HttpStatus.OK);
					
					} catch (Exception e) {
					    System.out.println("erreur "+e);
						return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
					}
					
					
				}	


//----------  Get Non Active Grafics by id grafic ------------------------------------------------------
	@GetMapping("/getNonActiveByIdGrafic")
				public ResponseEntity<List<Grafic_Resp>> getGraphicsNonActivebyIdGrafic(@RequestParam String cuid,@RequestParam String idGraphic){
					try {
							boolean isPilote = false;
							
							//response global 
							List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
							Grafic_Resp _graphic = new Grafic_Resp();
							
							//get All grafics containing id grafic
							List<Graphic> _allgraphics = graphic_Repository.findByidGraficContaining(idGraphic);
							_graphic = new Grafic_Resp();
							
							//get Collab infos
							Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
							//check if PILOTE
							if(_colab_req.getFonction().equals("3")) {
								isPilote = true;
							}
							
							if(isPilote){
								for(int i = 0; i < _allgraphics.size(); i++){
									if(!(_allgraphics.get(i).isActive())) {
									Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
									if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
										if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
											_graphic = new Grafic_Resp(
											_allgraphics.get(i).getidGrafic(),
											_allgraphics.get(i).getIar(),
											_allgraphics.get(i).getCode_imb(),
											_allgraphics.get(i).getgroupe_operation(),
											_allgraphics.get(i).getdateTraitement(),
											_allgraphics.get(i).getStatut_graphic(),
											_allgraphics.get(i).getTraitement_effectue(),
											_allgraphics.get(i).getType_traitement(),
											_allgraphics.get(i).getIdacte(),
											_colab.getNom() + " "+_colab.getPrenom(),
											_allgraphics.get(i).getDuree(),
											_allgraphics.get(i).getCommentaire()
										);
							
										response.add(_graphic);
										}
									}	
								}
								}
							}else{
					            for(int i = 0; i < _allgraphics.size(); i++){
					            	if(!(_allgraphics.get(i).isActive())) {
									Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
									if(_colab.getCUID().equals(cuid)){
										//System.out.println("OK");
										_graphic = new Grafic_Resp(
										_allgraphics.get(i).getidGrafic(),
										_allgraphics.get(i).getIar(),
										_allgraphics.get(i).getCode_imb(),
										_allgraphics.get(i).getgroupe_operation(),
										_allgraphics.get(i).getdateTraitement(),
										_allgraphics.get(i).getStatut_graphic(),
										_allgraphics.get(i).getTraitement_effectue(),
										_allgraphics.get(i).getType_traitement(),
										_allgraphics.get(i).getIdacte(),
										_colab.getNom() + " "+_colab.getPrenom(),
										_allgraphics.get(i).getDuree(),
										_allgraphics.get(i).getCommentaire()
									);
									response.add(_graphic);
									}
									
								}
					            }
							}
					        return new ResponseEntity<>(response, HttpStatus.OK);
							
							} catch (Exception e) {
							    System.out.println("erreur "+e);
								return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
							}
							
							
						}	

//------------------------ Get  Active Grafics by Date de Traitement ----------------------------------------
	   @GetMapping("/getActiveByIdDateTraitement")
			public ResponseEntity<List<Grafic_Resp>> getGraphicsActivebyDateTraitement(@RequestParam String cuid,@RequestParam String dateTtraitement){
				try {
						boolean isPilote = false;
						
						//response global 
						List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
						Grafic_Resp _graphic = new Grafic_Resp();
						
						//get All grafics containing id grafic
						List<Graphic> _allgraphics = graphic_Repository.findBydateTraitement(dateTtraitement);
						_graphic = new Grafic_Resp();
						
						//get Collab infos
						Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
						//check if PILOTE
						if(_colab_req.getFonction().equals("3")) {
							isPilote = true;
						}
						
						if(isPilote){
							for(int i = 0; i < _allgraphics.size(); i++){
								if(_allgraphics.get(i).isActive()) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
									if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
										_graphic = new Grafic_Resp(
										_allgraphics.get(i).getidGrafic(),
										_allgraphics.get(i).getIar(),
										_allgraphics.get(i).getCode_imb(),
										_allgraphics.get(i).getgroupe_operation(),
										_allgraphics.get(i).getdateTraitement(),
										_allgraphics.get(i).getStatut_graphic(),
										_allgraphics.get(i).getTraitement_effectue(),
										_allgraphics.get(i).getType_traitement(),
										_allgraphics.get(i).getIdacte(),
										_colab.getNom() + " "+_colab.getPrenom(),
										_allgraphics.get(i).getDuree(),
										_allgraphics.get(i).getCommentaire()
									);
						
									response.add(_graphic);
									}
								}	
							}
							}
						}else{
				            for(int i = 0; i < _allgraphics.size(); i++){
				            	if(_allgraphics.get(i).isActive()) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(_colab.getCUID().equals(cuid)){
									//System.out.println("OK");
									_graphic = new Grafic_Resp(
									_allgraphics.get(i).getidGrafic(),
									_allgraphics.get(i).getIar(),
									_allgraphics.get(i).getCode_imb(),
									_allgraphics.get(i).getgroupe_operation(),
									_allgraphics.get(i).getdateTraitement(),
									_allgraphics.get(i).getStatut_graphic(),
									_allgraphics.get(i).getTraitement_effectue(),
									_allgraphics.get(i).getType_traitement(),
									_allgraphics.get(i).getIdacte(),
									_colab.getNom() + " "+_colab.getPrenom(),
									_allgraphics.get(i).getDuree(),
									_allgraphics.get(i).getCommentaire()
								);
								response.add(_graphic);
								}
								
							}
				            }
						}
				        return new ResponseEntity<>(response, HttpStatus.OK);
						
						} catch (Exception e) {
						    System.out.println("erreur "+e);
							return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
						}
						
						
					}	
	
	   
//------------------------ Get Non Active Grafics by Date de Traitement ----------------------------------------
	   @GetMapping("/getNonActiveByIdDateTraitement")
			public ResponseEntity<List<Grafic_Resp>> getGraphicsNonActivebyDateTraitement(@RequestParam String cuid,@RequestParam String dateTtraitement){
				try {
						boolean isPilote = false;
						
						//response global 
						List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
						Grafic_Resp _graphic = new Grafic_Resp();
						
						//get All grafics containing id grafic
						List<Graphic> _allgraphics = graphic_Repository.findBydateTraitement(dateTtraitement);
						_graphic = new Grafic_Resp();
						
						//get Collab infos
						Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
						//check if PILOTE
						if(_colab_req.getFonction().equals("3")) {
							isPilote = true;
						}
						
						if(isPilote){
							for(int i = 0; i < _allgraphics.size(); i++){
								if(!(_allgraphics.get(i).isActive())) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
									if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
										_graphic = new Grafic_Resp(
										_allgraphics.get(i).getidGrafic(),
										_allgraphics.get(i).getIar(),
										_allgraphics.get(i).getCode_imb(),
										_allgraphics.get(i).getgroupe_operation(),
										_allgraphics.get(i).getdateTraitement(),
										_allgraphics.get(i).getStatut_graphic(),
										_allgraphics.get(i).getTraitement_effectue(),
										_allgraphics.get(i).getType_traitement(),
										_allgraphics.get(i).getIdacte(),
										_colab.getNom() + " "+_colab.getPrenom(),
										_allgraphics.get(i).getDuree(),
										_allgraphics.get(i).getCommentaire()
									);
						
									response.add(_graphic);
									}
								}	
							}
							}
						}else{
				            for(int i = 0; i < _allgraphics.size(); i++){
				            	if(!(_allgraphics.get(i).isActive())) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(_colab.getCUID().equals(cuid)){
									//System.out.println("OK");
									_graphic = new Grafic_Resp(
									_allgraphics.get(i).getidGrafic(),
									_allgraphics.get(i).getIar(),
									_allgraphics.get(i).getCode_imb(),
									_allgraphics.get(i).getgroupe_operation(),
									_allgraphics.get(i).getdateTraitement(),
									_allgraphics.get(i).getStatut_graphic(),
									_allgraphics.get(i).getTraitement_effectue(),
									_allgraphics.get(i).getType_traitement(),
									_allgraphics.get(i).getIdacte(),
									_colab.getNom() + " "+_colab.getPrenom(),
									_allgraphics.get(i).getDuree(),
									_allgraphics.get(i).getCommentaire()
								);
								response.add(_graphic);
								}
								
							}
				            }
						}
				        return new ResponseEntity<>(response, HttpStatus.OK);
						
						} catch (Exception e) {
						    System.out.println("erreur "+e);
							return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
						}
						
						
					}	
	   

//------------------------ Get Active Grafics by Affectation ---------------------------------------- 
@GetMapping("/getActiveByAffectation")
			public ResponseEntity<List<Grafic_Resp>> getGraphicsActivebyDateAffectation(@RequestParam String cuid,@RequestParam String affectation){
				try {
						boolean isPilote = false;
						
						//response global 
						List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
						Grafic_Resp _graphic = new Grafic_Resp();
						
						//get All grafics containing id grafic
						List<Graphic> _allgraphics = graphic_Repository.findByAffectation(affectation);
						_graphic = new Grafic_Resp();
						
						//get Collab infos
						Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
						//check if PILOTE
						if(_colab_req.getFonction().equals("3")) {
							isPilote = true;
						}
						
						if(isPilote){
							for(int i = 0; i < _allgraphics.size(); i++){
								if(_allgraphics.get(i).isActive()) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
									if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
										_graphic = new Grafic_Resp(
										_allgraphics.get(i).getidGrafic(),
										_allgraphics.get(i).getIar(),
										_allgraphics.get(i).getCode_imb(),
										_allgraphics.get(i).getgroupe_operation(),
										_allgraphics.get(i).getdateTraitement(),
										_allgraphics.get(i).getStatut_graphic(),
										_allgraphics.get(i).getTraitement_effectue(),
										_allgraphics.get(i).getType_traitement(),
										_allgraphics.get(i).getIdacte(),
										_colab.getNom() + " "+_colab.getPrenom(),
										_allgraphics.get(i).getDuree(),
										_allgraphics.get(i).getCommentaire()
									);
						
									response.add(_graphic);
									}
								}	
							}
							}
						}else{
				            for(int i = 0; i < _allgraphics.size(); i++){
				            	if(_allgraphics.get(i).isActive()) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(_colab.getCUID().equals(cuid)){
									//System.out.println("OK");
									_graphic = new Grafic_Resp(
									_allgraphics.get(i).getidGrafic(),
									_allgraphics.get(i).getIar(),
									_allgraphics.get(i).getCode_imb(),
									_allgraphics.get(i).getgroupe_operation(),
									_allgraphics.get(i).getdateTraitement(),
									_allgraphics.get(i).getStatut_graphic(),
									_allgraphics.get(i).getTraitement_effectue(),
									_allgraphics.get(i).getType_traitement(),
									_allgraphics.get(i).getIdacte(),
									_colab.getNom() + " "+_colab.getPrenom(),
									_allgraphics.get(i).getDuree(),
									_allgraphics.get(i).getCommentaire()
								);
								response.add(_graphic);
								}
								
							}
				            }
						}
				        return new ResponseEntity<>(response, HttpStatus.OK);
						
						} catch (Exception e) {
						    System.out.println("erreur "+e);
							return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
						}
						
						
					}

//------------------------ Get Non Active Grafics by Affectation ---------------------------------------- 
@GetMapping("/getNonActiveByAffectation")
			public ResponseEntity<List<Grafic_Resp>> getGraphicsNonActivebyDateAffectation(@RequestParam String cuid,@RequestParam String affectation){
				try {
						boolean isPilote = false;
						
						//response global 
						List<Grafic_Resp> response = new ArrayList<Grafic_Resp>();
						Grafic_Resp _graphic = new Grafic_Resp();
						
						//get All grafics containing id grafic
						List<Graphic> _allgraphics = graphic_Repository.findByAffectation(affectation);
						_graphic = new Grafic_Resp();
						
						//get Collab infos
						Collaborateur _colab_req = collaborateurRepository.findByCUID(cuid);
						//check if PILOTE
						if(_colab_req.getFonction().equals("3")) {
							isPilote = true;
						}
						
						if(isPilote){
							for(int i = 0; i < _allgraphics.size(); i++){
								if(!(_allgraphics.get(i).isActive())) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(Objects.nonNull(_colab) && Objects.nonNull(_colab_req)){
									if (_colab.getIdequipe().equals(_colab_req.getIdequipe()) ) {
										_graphic = new Grafic_Resp(
										_allgraphics.get(i).getidGrafic(),
										_allgraphics.get(i).getIar(),
										_allgraphics.get(i).getCode_imb(),
										_allgraphics.get(i).getgroupe_operation(),
										_allgraphics.get(i).getdateTraitement(),
										_allgraphics.get(i).getStatut_graphic(),
										_allgraphics.get(i).getTraitement_effectue(),
										_allgraphics.get(i).getType_traitement(),
										_allgraphics.get(i).getIdacte(),
										_colab.getNom() + " "+_colab.getPrenom(),
										_allgraphics.get(i).getDuree(),
										_allgraphics.get(i).getCommentaire()
									);
						
									response.add(_graphic);
									}
								}	
							}
							}
						}else{
				            for(int i = 0; i < _allgraphics.size(); i++){
				            	if(!(_allgraphics.get(i).isActive())) {
								Collaborateur _colab = collaborateurRepository.findByCUID(_allgraphics.get(i).getAffectation());
								if(_colab.getCUID().equals(cuid)){
									//System.out.println("OK");
									_graphic = new Grafic_Resp(
									_allgraphics.get(i).getidGrafic(),
									_allgraphics.get(i).getIar(),
									_allgraphics.get(i).getCode_imb(),
									_allgraphics.get(i).getgroupe_operation(),
									_allgraphics.get(i).getdateTraitement(),
									_allgraphics.get(i).getStatut_graphic(),
									_allgraphics.get(i).getTraitement_effectue(),
									_allgraphics.get(i).getType_traitement(),
									_allgraphics.get(i).getIdacte(),
									_colab.getNom() + " "+_colab.getPrenom(),
									_allgraphics.get(i).getDuree(),
									_allgraphics.get(i).getCommentaire()
								);
								response.add(_graphic);
								}
								
							}
				            }
						}
				        return new ResponseEntity<>(response, HttpStatus.OK);
						
						} catch (Exception e) {
						    System.out.println("erreur "+e);
							return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
						}
						
						
					}	


	//Update graphic
	@PutMapping("/Update")
	public String update(@RequestBody Graphic grafic){
		System.out.println("grafic.getIdacte()  : "+grafic.getIdacte());
		//get the graphic to update
		Graphic graphicData = graphic_Repository.findByidacte(grafic.getIdacte());

      
		//Update Acte Traitment
		if (Objects.nonNull(graphicData)) {
			graphic_Repository.save(grafic);
			return "ok";
		}else {
			return "KO";
		}

	}
	
	//Deactive graphic
		@PutMapping("/Deactive")
		public String Deactive(@RequestBody Graphic grafic){
			//get the graphic to deactive
			Graphic graphicData = graphic_Repository.findByidacte(grafic.getIdacte());
			//Update Acte Traitment
			if (Objects.nonNull(graphicData)) {
				graphicData.setActive(false);
				graphic_Repository.save(graphicData);
				return "ok";
			}else {
				return "KO";
			}

		}
    
	//Deactive graphic
	@PutMapping("/Active")
	public String Active(@RequestBody Graphic grafic){
		//get the graphic to deactive
		Graphic graphicData = graphic_Repository.findByidacte(grafic.getIdacte());
		//Update Acte Traitment
		if (Objects.nonNull(graphicData)) {
			graphicData.setActive(true);
			graphic_Repository.save(graphicData);
			return "OK";
		}else {
			return "KO";
		}
     }
// DONE -------------------------------------------------------------------------------------------------------------------------------------------
	
	
    


}
