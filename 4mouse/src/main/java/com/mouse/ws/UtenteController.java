package com.mouse.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UtenteController {
	
	@Autowired
	UtenteRepository utenteRepository;
	
	@GetMapping("/utente")
	public ResponseEntity<List<Utente>> getAllUtenti(@RequestParam(required = false) String email) {
		try {
			List<Utente> utenti = new ArrayList<Utente>();

			if (email == null)
				utenteRepository.findAll().forEach(utenti::add);
			else
				utenteRepository.findByemailContaining(email).forEach(utenti::add);

			if (utenti.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(utenti, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/utente/{email}")
	public ResponseEntity<Utente> getTutorialByEmail(@PathVariable("email") String email) {
		Optional<Utente> utenteData = utenteRepository.findById(email);

		if (utenteData.isPresent()) {
			return new ResponseEntity<>(utenteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	@PostMapping("/utente")
	public ResponseEntity<Utente> createTutorial(@RequestBody Utente utente) {
		try {
			System.out.println(utente);
			System.out.println(utente.getEmail());
			Utente _utente = utenteRepository.save(utente);
					//.save(new Utente(utente.getEmail(), utente.getPassword(), utente.getTipo()));
			return new ResponseEntity<>(_utente, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("errore: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/isauth")
	public ResponseEntity<Utente> isAuth(@RequestBody Utente utente) {
		try {
			Utente _utente = utenteRepository.findByEmailPwd(utente.getEmail(),utente.getPassword());
			if (_utente == null) {
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(_utente, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//Pass si fa per vedere che vada tutto!
	@PostMapping("/pass")
	public ResponseEntity<HttpStatus> pass() {
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/utente/{email}")
	public ResponseEntity<Utente> updateUtente(@PathVariable("email") String email, @RequestBody Utente utente) {
		Optional<Utente> utenteData = utenteRepository.findById(email);

		if (utenteData.isPresent()) {
			Utente _utente = utenteData.get();
			//_tutorial.setTitle(tutorial.getTitle()); Non si può fare :(
			_utente.setPassword(utente.getPassword());
			_utente.setTipo(utente.getTipo());
			return new ResponseEntity<>(utenteRepository.save(_utente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/utente/{email}")
	public ResponseEntity<HttpStatus> deleteUtente(@PathVariable("email") String email) {
		try {
			utenteRepository.deleteById(email);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}

/**

	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			utenteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// Diamo questo potere a qualcuno? 
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			utenteRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/tutorials/published")
	public ResponseEntity<List<Utente>> findByPublished() {
		try {
			List<Utente> tutorials = utenteRepository.findByPublished(1);

			if (tutorials.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}

	 */
