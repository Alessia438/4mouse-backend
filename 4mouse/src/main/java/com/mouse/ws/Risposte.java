package com.mouse.ws;

import javax.persistence.*;

@Entity
@Table(name = "risposte")
@IdClass(RisposteSerialize.class)

public class Risposte {
	
	@Id ////Database primary key
	@Column(name = "id_domanda")
	private Long IdDomanda;
	
	@Id ////Database primary key
	@Column(name = "id_risposte")
	private Long IdRisposte;

	@Column(name = "testo_risposta")
	private String testo_risposta;
	
	@Column(name = "punteggio")
	private int punteggio;
	
	public Risposte() {}
	
	public Risposte(Long idDomanda, Long idRisposte, String testo_risposta, int punteggio) {
		super();
		IdDomanda = idDomanda;
		IdRisposte = idRisposte;
		this.testo_risposta = testo_risposta;
		this.punteggio = punteggio;
	}

	public Long getIdDomanda() {
		return IdDomanda;
	}

	public void setIdDomanda(Long idDomanda) {
		IdDomanda = idDomanda;
	}

	public Long getIdRisposte() {
		return IdRisposte;
	}

	public void setIdRisposte(Long idRisposte) {
		IdRisposte = idRisposte;
	}

	public String getTesto_risposta() {
		return testo_risposta;
	}

	public void setTesto_risposta(String testo_risposta) {
		this.testo_risposta = testo_risposta;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	@Override
	public String toString() {
		return "Utente [id domanda=" + IdDomanda + ", id risposta=" + IdRisposte + ", testo Risposta=" + testo_risposta + ", punteggio=" + punteggio + "]";
	}

}
