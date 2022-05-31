package com.mouse.ws;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "esecuzione")
@IdClass(EsecuzioneSerialize.class)

public class Esecuzione {

@Id
@Column(name = "email")
private String email;

@Id
@Column(name = "id_test")
private long id_test ;

@Id
@Column(name = "id_domanda")
private long id_domanda;

@Column(name = "risposta_multipla")
private String risposta_multipla;

@Column(name = "risposta_aperta")
private String risposta_aperta;

@Column(name = "tempo")
private Time tempo;


public Esecuzione() {}

public Esecuzione(String email, long id_test, long id_domanda, String risposta_multipla, String risposta_aperta,
Time tempo) {

this.email = email;
this.id_test = id_test;
this.id_domanda = id_domanda;
this.risposta_multipla = risposta_multipla;
this.risposta_aperta = risposta_aperta;
this.tempo = tempo;
}

public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public long getId_test() {
return id_test;
}
public void setId_test(long id_test) {
this.id_test = id_test;
}
public long getId_domanda() {
return id_domanda;
}
public void setId_domanda(long id_domanda) {
this.id_domanda = id_domanda;
}
public String getRisposta_multipla() {
return risposta_multipla;
}
public void setRisposta_multipla(String risposta_multipla) {
this.risposta_multipla = risposta_multipla;
}
public String getRisposta_aperta() {
return risposta_aperta;
}
public void setRisposta_aperta(String risposta_aperta) {
this.risposta_aperta = risposta_aperta;
}
public Time getTempo() {
return tempo;
}
public void setTempo(Time tempo) {
this.tempo = tempo;
}

@Override
public String toString() {
return "Esecuzione [email=" + email + ", id_test=" + id_test + ", id_domanda=" + id_domanda + "risposta_multipla="+ risposta_multipla+ ", risposta_aperta=" + risposta_aperta + ", tempo=" + tempo + "]";
}




}

/*package com.mouse.ws;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "esecuzione")
@IdClass(EsecuzioneSerialize.class)

public class Esecuzione {
	
	@Id ////Database primary key
	@Column(name = "email")
	private String email;
	
	@Id ////Database primary key
	@Column(name = "id_test")
	private long id_test;
	
	@Id ////Database primary key
	@Column(name = "id_domanda")
	private long id_domanda;

	@Column(name = "risposta_multipla")
	private String rispostaMultipla;
	
	@Column(name = "risposta_aperta")
	private String risposta_aperta;
	
	@Column(name = "tempo")
	private Time tempo;
	
	// constructors
	public Esecuzione() {};

	public Esecuzione(String email, long id_test, long id_domanda, String rispostaMultipla, String risposta_aperta,
			Time tempo) {
		super();
		this.email = email;
		this.id_test = id_test;
		this.id_domanda = id_domanda;
		this.rispostaMultipla = rispostaMultipla;
		this.risposta_aperta = risposta_aperta;
		this.tempo = tempo;
	}

	// getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId_test() {
		return id_test;
	}

	public void setId_test(long id_test) {
		this.id_test = id_test;
	}

	public long getId_domanda() {
		return id_domanda;
	}

	public void setId_domanda(long id_domanda) {
		this.id_domanda = id_domanda;
	}

	public String getRispostaMultipla() {
		return rispostaMultipla;
	}

	public void setRispostaMultipla(String rispostaMultipla) {
		this.rispostaMultipla = rispostaMultipla;
	}

	public String getRispostaAperta() {
		return risposta_aperta;
	}

	public void setRispostaAperta(String risposta_aperta) {
		this.risposta_aperta = risposta_aperta;
	}

	public Time getTempo() {
		return tempo;
	}

	public void setTempo(Time time) {
		this.tempo = time;
	}
	
	@Override
	public String toString() {
		return "Utente [email=" + email + ", id Test=" + id_test + ", rispostaMultipla=" + id_domanda + ", rispostaMultipla=" + rispostaMultipla + ", rispostaAperta=" + risposta_aperta + ", tempo=" + tempo + "]";
	}

}
*/