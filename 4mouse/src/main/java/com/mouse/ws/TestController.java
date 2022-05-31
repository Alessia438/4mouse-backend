package com.mouse.ws;

import java.util.ArrayList;
import java.util.List;
//import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class TestController {
	
	@Autowired
	TestRepository testRepository;
	
	@Autowired
	DomandeRepository domandeRepository;
	
	@Autowired
	DomandeTestRepository domandeTestRepository;
	
	@Autowired
	RisposteRepository risposteRepository;
	
	@GetMapping("/test/{data}")
	//public ResponseEntity<Test> Test (@PathVariable("data") String data){
	public ResponseEntity<outputJson> Test (@PathVariable("data") String data){
		try {
			System.out.println("Data: " + data);
			Optional<Test> testData = testRepository.findByData(data);
			System.out.println("Data: " + testData);
			//check if data is not null
			if(testData.isPresent()) {
				//get the test
				long IdTest = testData.get().getIdTest();
				System.out.println("id test: " + IdTest);	
				
				//get the test questions
				List<DomandeTest> DomandeTest = domandeTestRepository.findByIdTest(IdTest);
				System.out.println("Domande: " + DomandeTest);
				
				// check if there are questions in current test
				if (DomandeTest == null) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				
				int size = DomandeTest.size();
				System.out.println(size);
				List<Domande> domande = new ArrayList<Domande>();
				List<Long> ids = new ArrayList<Long>();
				
				// cycle to add all questions to final list
				for(int i=0; i<size; i++) {
					//System.out.println(i);
					//List<Domande> domanda = domandeRepository.findById(i);
					long item = DomandeTest.get(i).getIdDomanda();
					ids.add(item);
					//System.out.println(item);
					List<Domande> domanda = domandeRepository.findById((int)item);
					//System.out.println(domanda);
					
					domande.addAll(domanda);
				}
				
				System.out.println("Lista domande: " + domande);
				
				List<Risposte> risposte = new ArrayList<Risposte>();
				
				// cycle to add all answers to final list
				for(int i=0; i<size; i++) {
					//List<Risposte> risposta = risposteRepository.findById(i);
					
					long item = ids.get(i);
					//System.out.println(item);
					List<Risposte> risposta = risposteRepository.findById(item);
					risposte.addAll(risposta);
					//System.out.println(risposta);
				}
				
				// se la lista delle risposte è vuota, significa che è una domanda aperta
				System.out.println("Lista risposte: " + risposte);
				

				
				// CREAZIONE JSON - in this piece of code I create the JSON to send as output of the request. 
				//creare array da riempire con elementi della classe testJson
				ArrayList<testJson> test = new ArrayList<testJson>();
				
				for (int i=0; i<size; i++) {
					long idQuestion = domande.get(i).getIdDomanda();
					String testQuestion = domande.get(i).getTesto();
					int modalita = domande.get(i).getModalità();
					
					// create an object with the answers to each question
					List<answerJson> answers = new ArrayList<answerJson>();
					for (int a = 0; a<risposte.size(); a++) {  // per ogni risposta nella lista di risposte
						if (risposte.get(a).getIdDomanda() == idQuestion) {   // se la risposta ha l'id della domanda corrente
							// identifica i parametri di cui è formato l'oggetto risposta
							long idAnswer = risposte.get(a).getIdRisposte();
							String testAnswer = risposte.get(a).getTesto_risposta();
							int punteggio = risposte.get(a).getPunteggio();
							// crea l'oggetto risposta corrente con i parametri identificati e aggiungila alla lista di risposte
							answerJson curAnswer = new answerJson(String.valueOf(idAnswer), testAnswer, punteggio);
							answers.add(curAnswer);
						}
					}
					
					//System.out.println("id domande: " + idQuestion + ", testo domanda: " + testQuestion +  ", modalità: " + modalita +  ", lista risposte: " + answers);

					testJson curTest = new testJson(String.valueOf(idQuestion), testQuestion, modalita, answers);
					//System.out.println(curTest);
					test.add(curTest);
				}
				
				// creare oggetto di classe outputJson con i valori correnti
				//outputJson outTest = new outputJson(HttpStatus.CREATED, test);
				outputJson outTest = new outputJson(HttpStatus.CREATED, IdTest, test);
				
				System.out.println("Stampa a video dell'outTest: " + outTest.toString());
				
				// creation of a http header to send as answer
		        HttpHeaders headers = new HttpHeaders();
				//System.out.println(headers);

		        // creating the final answer with header, status and json 
		        ResponseEntity<outputJson> output = new ResponseEntity<>(outTest,headers,HttpStatus.OK);
		        //System.out.println(output);
		        
		        // returning output 
		        return output;
				
				//FINE CREAZIONE JSON
		        
				
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//return null;
	}
	

}
