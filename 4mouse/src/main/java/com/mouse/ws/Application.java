package com.mouse.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	//Questo è il punto di Bootstrap, l'entry point dell'applicazione

	public static void main(String[] args) { 
		SpringApplication.run(Application.class, args);
	}

}
