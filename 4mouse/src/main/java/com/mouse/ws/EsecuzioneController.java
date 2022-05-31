package com.mouse.ws;

import java.sql.Time;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class EsecuzioneController {

	@Autowired
	EsecuzioneRepository esecuzioneRepository;
	
	@PostMapping("/esecuzione")
	public ResponseEntity<Void> esecuzione(@RequestBody Esecuzione esecuzione) {
		try {
			System.out.println(esecuzione.toString());
			Optional<Esecuzione> isPresent = esecuzioneRepository.findEsecuzione(esecuzione.getEmail(), esecuzione.getId_test(), esecuzione.getId_domanda());
			if (isPresent.isPresent()) {
				Esecuzione _esecuzione = esecuzione;
				_esecuzione.setTempo(new Time(System.currentTimeMillis()));
				esecuzioneRepository.save(_esecuzione);
				return new ResponseEntity<>(HttpStatus.FOUND);
			}
			else {
				Esecuzione _esecuzione = esecuzione;
				_esecuzione.setTempo(new Time(System.currentTimeMillis()));
				esecuzioneRepository.save(_esecuzione);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
