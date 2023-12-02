package com.gestion.etudiants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity(filierecree,HttpStatusCode.valueOf(200));
	}

}
