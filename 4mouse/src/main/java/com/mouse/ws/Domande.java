package com.mouse.ws;

import javax.persistence.*;

@Entity
@Table(name = "domande")

public class Domande {
	
	@Id ////Database primary key
	private long id_domanda;

	@Column(name = "testo_domanda")
	private String testo_domanda;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "modalita")
	private int modalita;
	
	public Domande() {}

	public Domande(long idDomanda, String testo, String categoria, int modalità) {
		super();
		id_domanda = idDomanda;
		this.testo_domanda = testo;
		this.categoria = categoria;
		this.modalita = modalità;
	}

	public long getIdDomanda() {
		return id_domanda;
	}

	public void setIdDomanda(long idDomanda) {
		id_domanda = idDomanda;
	}

	public String getTesto() {
		return testo_domanda;
	}

	public void setTesto(String testo) {
		this.testo_domanda = testo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getModalità() {
		return modalita;
	}

	public void setModalità(int modalità) {
		this.modalita = modalità;
	}
	
	@Override
	public String toString() {
		return "Utente [id domanda=" + id_domanda + ", testo=" + testo_domanda + ", categoria=" + categoria + ", modalità=" + modalita + "]";
	}

}
