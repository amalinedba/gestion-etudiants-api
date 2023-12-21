package com.gestion.etudiants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gestion.etudiants.controller.dto.FiliereDTO;
import com.gestion.etudiants.services.FiliereService;

@RestController
@RequestMapping("api/filieres/")
public class FiliereController {
	
	@Autowired
	private FiliereService filiereService;
	
	@GetMapping
	ResponseEntity<List<FiliereDTO>> obtenirListeFilieres(){
		List<FiliereDTO> filieres = filiereService.getAllFilieres();
		return new ResponseEntity(filieres,HttpStatusCode.valueOf(200));
	}
	
	@PostMapping
	ResponseEntity<FiliereDTO> creerFiliere(@RequestBody FiliereDTO filiereDTO){
		FiliereDTO filierecree = filiereService.addFiliere(filiereDTO);
		System.out.println(filiereDTO);
		// Ajouter LOG4J 
		return new ResponseEntity(filierecree,HttpStatusCode.valueOf(200));
	}

	@PutMapping("/{id}")
	public ResponseEntity<FiliereDTO> updateFiliere(@PathVariable int id, @RequestBody FiliereDTO filiereDTO) {
		FiliereDTO updatedFiliere = filiereService.updateFiliere(id, filiereDTO);
		if (updatedFiliere != null) {
			return new ResponseEntity<>(updatedFiliere, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
