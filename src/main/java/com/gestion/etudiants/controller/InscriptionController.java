package com.gestion.etudiants.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.etudiants.modeles.InscriptionRequest;

@RestController
@RequestMapping("api/inscriptions/")
public class InscriptionController {
	
	@PostMapping("add")
	ResponseEntity<InscriptionRequest> creerInscription(@RequestBody InscriptionRequest inscriptionRequest){
		return new ResponseEntity(null,HttpStatusCode.valueOf(200));
	}

}
