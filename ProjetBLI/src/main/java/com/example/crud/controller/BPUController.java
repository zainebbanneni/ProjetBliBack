package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.BPU;
import com.example.crud.repository.BPURepository;

@RestController
@RequestMapping("/api")
public class BPUController {
	
	@Autowired
	BPURepository bpuRepository;
	
	// Add BPU
	@PostMapping("/bpus")
	public ResponseEntity<BPU> createBPU(@RequestBody BPU bpu) {
		try {
			BPU _bpu = bpuRepository
					.save(new BPU(bpu.getRefTacheBPU(),bpu.getType_element(),bpu.getPU(),bpu.getDateValidite(),
							bpu.getDateExpiration(),bpu.getType_penalite(),bpu.getPenalite(), 
							  bpu.getType_prestation()));
			return new ResponseEntity<>(_bpu, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Get all BPUs
	@GetMapping("/bpus")
	public List<BPU> getAll(){
		return bpuRepository.findAll();
	}
	
	//Get BPU by id
	@GetMapping("/bpus/{id}")
	public ResponseEntity<BPU> getBPUById(@PathVariable("id") long id) {
		Optional<BPU> bpuData = bpuRepository.findById(id);

		if (bpuData.isPresent()) {
			return new ResponseEntity<>(bpuData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Modif BPU
	@PutMapping("/bpus/{id}")
	public ResponseEntity<BPU> updateBPU(@PathVariable("id") long id, @RequestBody BPU bpu) {
		Optional<BPU> bpuData = bpuRepository.findById(id);

		if (bpuData.isPresent()) {
			BPU _bpu = bpuData.get();
			_bpu.setRefTacheBPU(bpu.getRefTacheBPU());
			_bpu.setType_prestation(bpu.getType_prestation());
			_bpu.setType_element(bpu.getType_element());
			_bpu.setDateExpiration(bpu.getDateExpiration());
			_bpu.setDateValidite(bpu.getDateValidite());
			_bpu.setPenalite(bpu.getPenalite());
			_bpu.setType_penalite(bpu.getType_penalite());
			_bpu.setPU(bpu.getPU());
			return new ResponseEntity<>(bpuRepository.save(_bpu), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//Supp BPU by id
	@DeleteMapping("/bpus/{id}")
	public ResponseEntity<HttpStatus> deleteBPU(@PathVariable("id") long id) {
		try {
			bpuRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Supp all BPUs
	@DeleteMapping("/bpus")
	public ResponseEntity<HttpStatus> deleteAllBPUs() {
		try {
			bpuRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
